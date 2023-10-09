package cc.robotdreams.cucumber.steps;

import cc.robotdreams.kanboard.ui.LoginPage;
import com.codeborne.selenide.Selenide;
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
        loginPage = new LoginPage();
        this.loginPage.goToLoginPage();

    }

    @When("User set field value {string} on login page")
    public void UserSetFieldValue(String fieldValue) {
       try{ this.loginPage.userName.sendKeys(fieldValue);
       } catch (Exception e){
       }
    }

    @And("User enter field value {string} on login page")
    public void UserEnterFieldValue(String fieldValue){
        try{ this.loginPage.password.sendKeys(fieldValue);
        } catch (Exception e){
        }
    }

    @And("User clicks on the \"Login\" button")
    public void UserClicksLoginButton() {

        this.loginPage.signInButton.click();
    }


    @Then("Dashboard is displayed")
    public void dashboardIsDisplayed() {
        String expectedText = "Dashboard for admin";
        String actualText = Selenide.$x("//div/h1/span[2]").getText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text is not found on the page.");
    }

}
