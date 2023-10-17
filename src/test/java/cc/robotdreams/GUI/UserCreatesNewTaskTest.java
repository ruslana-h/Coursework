package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import cc.robotdreams.utils.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI tests")
public class UserCreatesNewTaskTest extends TestPrecondition
{
    @Description("User creates new task UI test")
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
