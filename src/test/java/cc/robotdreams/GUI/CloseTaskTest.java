package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI tests")
public class CloseTaskTest extends TestPrecondition
{
    @Description("Close created task UI test")
    @Test
    public void closeTask()
    {
        LoginUserTest login = new LoginUserTest();
        login.loginUser();
        DashboardPage dashboard = new DashboardPage();
        dashboard.myProject.click();
        dashboard.createdProject.click();
        CreateNewTaskPage newTask = new CreateNewTaskPage();
        newTask.createTask();
        dashboard.returnToDashboard.click();
        dashboard.myTasks.click();
        dashboard.createdTask.click();
        dashboard.closeTask.click();
        dashboard.confirmButton.click();
        Assert.assertEquals(dashboard.status.getText(), "closed", "Task is not closed");
    }
}
