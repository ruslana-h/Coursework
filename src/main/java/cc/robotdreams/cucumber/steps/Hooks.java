package cc.robotdreams.cucumber.steps;

import cc.robotdreams.utils.Config;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.WebDriver;


public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        Selenide.open(String.format("http://%s:%s/%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value,
                Config.HTTP_BASE_PAGE.value
        ));
    }


    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.getStatus() == Status.FAILED) {
            Selenide.screenshot("failure-screenshot");
        }
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
