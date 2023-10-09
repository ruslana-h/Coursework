package cc.robotdreams.GUI;


import cc.robotdreams.kanboard.ui.CreateNewProjectPage;
import cc.robotdreams.kanboard.ui.LoginPage;
import cc.robotdreams.utils.TestSetupTeardown;
import cc.robotdreams.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateNewProjectTest extends TestSetupTeardown
{
    LoginPage loginPage;
    CreateNewProjectPage newProjectPage;

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
