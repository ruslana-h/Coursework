package cc.robotdreams.kanboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CreateNewProjectPage
{
    final public SelenideElement projectName = Selenide.$x("//input[@id='form-name']");
    final public SelenideElement projectIdentifier = Selenide.$x("//input[@id='form-identifier']");
}
