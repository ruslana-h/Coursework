package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloseTaskTest extends TestPrecondition
{
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
