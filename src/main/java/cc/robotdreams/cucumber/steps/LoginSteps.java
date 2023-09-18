package cc.robotdreams.cucumber.steps;

import cc.robotdreams.kanboard.LoginPage;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class LoginSteps
{
    LoginPage loginPage;

    @Given("User navigates to login page")
    public void UserNavigatesToLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.goToLoginPage();

    }

    @When("User set field value {string} on login page")
    public void UserSetFieldValue(String fieldValue) {
       try{ loginPage.userName.sendKeys(fieldValue);
       } catch (Exception e){
       }
    }

    @And("User enter field value {string} on login page")
    public void UserEnterFieldValue(String fieldValue){
        try{ loginPage.password.sendKeys(fieldValue);
        } catch (Exception e){
        }
    }

    @And("User clicks on the \"Login\" button")
    public void UserClicksLoginButton() {
        loginPage.signInButton.click();
    }


    @Then("Error message is not displayed on the login page")
    public void errorMessageIsNotDisplayedOnLoginPage() {
        SelenideElement errorMessage = loginPage.errorMessage;
        Assert.assertFalse(errorMessage.exists(), "Error message is present: " + errorMessage.getText());

    }

}
