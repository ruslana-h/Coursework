package cc.robotdreams.GUI;

import cc.robotdreams.API.TestPrecondition;
import cc.robotdreams.kanboard.ui.CreateNewTaskPage;
import cc.robotdreams.kanboard.ui.DashboardPage;
import cc.robotdreams.kanboard.ui.SaveButton;
import cc.robotdreams.utils.TestData;
import cc.robotdreams.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAddCommentForTask extends TestPrecondition
{
    @Test
    public void addComment(){
        String commentText = TestData.COMMENT_TEXT.getValue();
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
