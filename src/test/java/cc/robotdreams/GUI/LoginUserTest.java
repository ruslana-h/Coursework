package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.api.POJO.CreateUser;
import cc.robotdreams.kanboard.api.TestData;
import cc.robotdreams.kanboard.ui.LoginPage;
import cc.robotdreams.utils.TestSetupTeardown;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI tests")
public class LoginUserTest extends TestPrecondition
{
    @Description("Login user UI test")
    @Test
    public void loginUser()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLoginPage();

        loginPage.userName.sendKeys(TestData.USERNAME);
        loginPage.password.sendKeys(TestData.PASSWORD);

        loginPage.signInButton.click();
        String expectedText = "Dashboard for " + TestData.USERNAME;
        String actualText = Selenide.$x("//div/h1/span[2]").getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text is not found on the page.");
    }
}
