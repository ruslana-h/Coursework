package cc.robotdreams.kanboard.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class BoardPage
{
    final public SelenideElement addTaskInBacklog = Selenide.$x("//th[1]/div/div[@class='board-add-icon']/a");
    final public SelenideElement taskTitle = Selenide.$x("//div/input[@id='form-title']");
    final public SelenideElement taskDescription = Selenide.$x("//div/textarea[@name='description']");

}
