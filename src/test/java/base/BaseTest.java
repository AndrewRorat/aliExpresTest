package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import AliExpres.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    protected HomePage homePage;
    private final String CHROME_DRIVER_INIT = "webdriver.chrome.driver";
    private final String GECKO_DRIVER_INIT = "webdriver.gecko.driver";
    private final String CHROME_DRIVER_FILE_PATH = "C:src\\main\\resources\\chromedriver.exe";
    private final String GECKO_DRIVER_FILE_PATH = "C:src\\main\\resources\\geckodriver.exe";
    private final String URL = "https://aliexpress.ru/";

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty(CHROME_DRIVER_INIT, CHROME_DRIVER_FILE_PATH);
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty(GECKO_DRIVER_INIT, GECKO_DRIVER_FILE_PATH);
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.closePopUpWindow();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}