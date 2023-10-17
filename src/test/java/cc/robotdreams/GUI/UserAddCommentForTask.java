package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.api.JsonRequestGenerator;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import cc.robotdreams.kanboard.ui.SaveButton;
import cc.robotdreams.utils.TestData;
import cc.robotdreams.utils.Wait;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("UI tests")
public class UserAddCommentForTask extends TestPrecondition
{
    @Description("Add comment for created task UI test")
    @Test
    public void addComment(){
        String commentText = JsonRequestGenerator.generateRandomTitle();
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
        dashboard.comment.click();
        dashboard.commentField.sendKeys(commentText);
        Wait.sleep(3000);
        SaveButton saveButton = new SaveButton();
        saveButton.saveButton.click();
        Wait.sleep(3000);
        Assert.assertEquals(dashboard.addedComment.getText(), commentText, "The comments do not match");
    }
}
