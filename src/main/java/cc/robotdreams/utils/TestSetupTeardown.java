package cc.robotdreams.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestSetupTeardown implements ITestNGListener
{
    @BeforeMethod
    public void setUp() {
        Configuration.reportsFolder = "target/allure-results";
        Selenide.open(String.format("http://%s:%s/%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value,
                Config.HTTP_BASE_PAGE.value
        ));
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
