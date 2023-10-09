package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import cc.robotdreams.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreatesNewTaskTest extends TestPrecondition
{
    @Test
    public void userCreateNewTask()
    {
        LoginUserTest login = new LoginUserTest();
        login.loginUser();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.myProject.click();
        dashboardPage.createdProject.click();
        CreateNewTaskPage newTask = new CreateNewTaskPage();
        newTask.createTask();
        Assert.assertEquals(newTask.createdTask.getText(), TestData.TASK_NAME.getValue(), "Task name does not match");

    }
}
