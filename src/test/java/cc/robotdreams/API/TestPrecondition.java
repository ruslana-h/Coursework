package cc.robotdreams.API;

import cc.robotdreams.utils.TestSetupTeardown;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestPrecondition extends TestSetupTeardown
{
    CreateDeleteUserTest user = new CreateDeleteUserTest();
    CreateDeleteProjectTest project = new CreateDeleteProjectTest();

    @BeforeTest
    public void before()
    {
        user.createNewUser();
        project.createNewProject();
        project.addProjectUser();

    }

    @AfterTest
    public void after()
    {
        project.deleteProject();
        user.deleteUser();
        System.out.println("Data is deleted");
    }
}
