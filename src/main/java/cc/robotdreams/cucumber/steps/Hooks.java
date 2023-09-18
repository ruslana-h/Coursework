package cc.robotdreams.cucumber.steps;

import cc.robotdreams.utils.Config;
import cc.robotdreams.utils.Session;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.WebDriver;

public class Hooks
{
    @Before
    public void before(Scenario scenario) {
        this.wd().get(String.format("http://%s:%s/%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value,
                Config.HTTP_BASE_PAGE.value
        ));
        WebDriverRunner.setWebDriver(this.wd());
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.getStatus() == Status.FAILED) {
            // Take screenshot
            // Attach to report
        }
        Session.get().close();
    }

    protected WebDriver wd() {
        return (WebDriver) Session.get();
    }
}
