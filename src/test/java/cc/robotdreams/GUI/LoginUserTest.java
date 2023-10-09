package cc.robotdreams.GUI;

import cc.robotdreams.kanboard.ui.LoginPage;
import cc.robotdreams.utils.TestData;
import cc.robotdreams.utils.TestSetupTeardown;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserTest extends TestSetupTeardown
{
    @Test
    public void loginUser()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLoginPage();
        String userName = TestData.USER_NAME.getValue();
        String password = TestData.PASSWORD.getValue();

        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);

        loginPage.signInButton.click();
        String expectedText = "Dashboard for " + userName;
        String actualText = Selenide.$x("//div/h1/span[2]").getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text is not found on the page.");
    }
}
