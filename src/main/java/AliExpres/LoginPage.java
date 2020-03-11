package AliExpres;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "alibaba-login-box")
    private WebElement iFrame;

    @FindBy(xpath = "//li[@data-name='sign']")
    private WebElement signInTab;

    @FindBy(xpath = "//input[@id='fm-login-id']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='fm-login-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='user-account olduser-account']")
    private WebElement helloUa;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enter to the IFrame;
     */
    public LoginPage switchToIFrame() {
        driver.switchTo().frame(iFrame);
        return this;
    }

    public LoginPage insertEmail(String email) {
        emailAddressField.click();
        emailAddressField.sendKeys(email);
        return this;
    }

    public LoginPage insertPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnSignInButton() {
        signInTab.click();
        return this;
    }

    public HomePage clickOnSubmitButton() {
        submitButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}