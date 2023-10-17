package cc.robotdreams.kanboard.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CreateNewProjectPage
{
    final public SelenideElement createProject = Selenide.$x("//div[@class='page-header']/ul/li[1]/a");
    final public SelenideElement projectName = Selenide.$x("//input[@id='form-name']");
    final public SelenideElement projectIdentifier = Selenide.$x("//input[@id='form-identifier']");
    final public SelenideElement addedProject = Selenide.$x("//div/h1/span[2]");
    final public String name = "Test Project2";
    final public String identifier = "TST";
    public void addNewProject(){
        createProject.click();
        projectName.sendKeys(name);
        projectIdentifier.sendKeys(identifier);
        SaveButton button = new SaveButton();
        button.saveButton.click();
    }
}
