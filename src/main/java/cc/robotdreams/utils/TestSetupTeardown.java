package cc.robotdreams.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGListener;
import org.testng.annotations.*;

public class TestSetupTeardown implements ITestNGListener
{
    @BeforeClass
    public void setUp()
    {
        Configuration.reportsFolder = "target/allure-results";
        Selenide.open(String.format("http://%s:%s/%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value,
                Config.HTTP_BASE_PAGE.value
        ));
    }

    @AfterClass
    public void tearDown()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
