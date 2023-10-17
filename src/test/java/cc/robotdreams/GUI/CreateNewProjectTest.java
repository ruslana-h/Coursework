package cc.robotdreams.GUI;


import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewProjectPage;
import cc.robotdreams.kanboard.ui.LoginPage;
import cc.robotdreams.utils.TestSetupTeardown;
import cc.robotdreams.utils.Wait;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI tests")
public class CreateNewProjectTest extends TestPrecondition
{
    LoginPage loginPage;
    CreateNewProjectPage newProjectPage;
    @Description("Create new project for logged in user UI test")
    @Test
    public void CreateNewProject(){
        loginPage = new LoginPage();
        loginPage.fillInLoginForm();
        newProjectPage = new CreateNewProjectPage();
        newProjectPage.addNewProject();
        Wait.sleep(2000);
        String expectedText = newProjectPage.name;
        String actualText = newProjectPage.addedProject.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text is not found on the page.");

    }
}
