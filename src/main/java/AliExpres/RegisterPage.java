package AliExpres;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@data-name='register']")
    private WebElement registerTab;

    @FindBy(xpath = "//input[@id='ws-xman-register-email']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='ws-xman-register-password']")
    private WebElement passwordField;

    @FindBy(id = "ws-xman-register-submit")
    private WebElement createAccountButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickOnRegisterTab() {
        registerTab.click();
        return this;
    }

    public RegisterPage enterEmailAddress(String email) {
        emailAddressField.click();
        emailAddressField.sendKeys(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage clickOnCreateAccountButton() {
        createAccountButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}