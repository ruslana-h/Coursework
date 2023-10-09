package cc.robotdreams.kanboard.ui;

import cc.robotdreams.utils.Wait;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage
{
    final public SelenideElement userName = Selenide.$x("//input[@id='form-username']");
    final public SelenideElement password = Selenide.$x("//input[@id='form-password']");
    final public SelenideElement signInButton = Selenide.$x("//button[@type='submit']");
    final public SelenideElement errorMessage = Selenide.$x("//*[contains(text(), 'Bad username or password')]");
    final public String userNameValue = "admin";
    final public String passwordValue = "admin";
    public SelenideElement isErrorMessagePresent() {
        Wait.waitWhilePageIsLoading();

        return errorMessage.shouldBe(Condition.exist, Condition.visible, Condition.appear, Condition.enabled, Condition.not(Condition.empty));
    }

    public LoginPage goToLoginPage() {
        return new LoginPage();
    }
    public void fillInLoginForm(){
        userName.sendKeys(userNameValue);
        password.sendKeys(passwordValue);
        signInButton.click();
    }
}
