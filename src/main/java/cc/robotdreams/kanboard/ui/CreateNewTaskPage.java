package cc.robotdreams.kanboard.ui;

import cc.robotdreams.kanboard.api.TestData;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static cc.robotdreams.kanboard.api.TestData.*;


public class CreateNewTaskPage
{
    final public SelenideElement addNewTask = Selenide.$x("//th[1]/div[2]/div[@class='board-add-icon']/a");
    final public SelenideElement taskTitle = Selenide.$x("//input[@id='form-title']");
    final public SelenideElement taskDescription = Selenide.$x("//textarea[@name='description']");
    final public SelenideElement createdTask = Selenide.$x("//div[@class='task-board-title']/a");
    final public SelenideElement addAssignee = Selenide.$x("//a[@title = 'Assign to me']");

    public void createTask()
    {
        addNewTask.click();
        taskTitle.sendKeys(TASK_TITLE);
        taskDescription.sendKeys(TASK_DESC);
        addAssignee.click();
        SaveButton saveButton = new SaveButton();
        saveButton.saveButton.click();
    }

}
