package cc.robotdreams.kanboard;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SaveButton
{
    final public SelenideElement saveButton = Selenide.$x("//div/button[@type='submit']");
}
