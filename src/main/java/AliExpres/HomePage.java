package AliExpres;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='register-btn']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@class='close-layer']")
    private WebElement popUpCouponWindow;

    @FindBy(xpath = "//span[@class='join-btn']")
    private WebElement signInButton;

    @FindBy(xpath = "//ul[@class='fast-entry-list util-clearfix']/*[1]/*[1]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//div[@class='coupon-detail']")
    private WebElement welcomeWindow;

    @FindBy(xpath = "//div[@class='welcome']")
    private WebElement welcomeText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Close Popup window if it is display;
     */
    public HomePage closePopUpWindow() {
        try {
            popUpCouponWindow.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RegisterPage clickOnRegisterButton() {
        registerButton.click();
        return PageFactory.initElements(driver, RegisterPage.class);
    }

    public LoginPage clickOnSignInButton() {
        signInButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    /**
     * Exit from IFrame;
     */
    public HomePage switchFromIFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    /**
     * For TestLoginPage.class assert
     */
    public boolean isMyProfileButtonDisplayed() {
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(myProfileButton)).isDisplayed();
    }

    /**
     * For TestRegistrationPage.class assert
     */
    public boolean isWelcomeWindowDisplayed() {
        return welcomeWindow.isDisplayed();
    }
}