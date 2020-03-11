package register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    @Parameters({"email", "password"})
    @Test(description = "Verify that registration form works correct")
    public void testRegistration(String email, String password) {

        homePage = homePage
                .clickOnRegisterButton()
                .clickOnRegisterTab()
                .enterEmailAddress(email)
                .enterPassword(password)
                .clickOnCreateAccountButton();


        Assert.assertTrue(homePage.isWelcomeWindowDisplayed(),
                "Welcome window is not displayed");
    }
}