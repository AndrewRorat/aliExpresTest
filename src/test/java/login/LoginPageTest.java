package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Parameters({"email", "password"})
    @Test(description = "Verify that registration form works correctly")
    public void testLogin(String email, String password) {

        homePage = homePage
                .clickOnSignInButton()
                .clickOnSignInButton()
                .switchToIFrame()
                .insertEmail(email)
                .insertPassword(password)
                .clickOnSubmitButton()
                .switchFromIFrame();

        Assert.assertTrue(homePage.isMyProfileButtonDisplayed(),
                "My profile button is not displayed");
    }
}