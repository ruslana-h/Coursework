package cc.robotdreams.GUI;

import cc.robotdreams.kanboard.BoardPage;
import cc.robotdreams.kanboard.DashboardPage;
import cc.robotdreams.kanboard.LoginPage;
import cc.robotdreams.utils.CustomWebDriverProvider;
import cc.robotdreams.utils.TestSetupTeardown;
import cc.robotdreams.utils.Wait;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({TestSetupTeardown.class})

public class CreateNewProjectTest extends TestSetupTeardown
{
    LoginPage loginPage;

    @Test
    public void CreateNewProject(){
        loginPage = new LoginPage();
        this.loginPage.goToLoginPage();
        loginPage.userName.sendKeys("admin");
        loginPage.password.sendKeys("admin");
        loginPage.signInButton.click();
        String expectedText = "Dashboard for admin";
        String actualText = Selenide.$x("//div/h1/span[2]").getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text is not found on the page.");

    }
}
