package cc.robotdreams.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.screenshot;
import io.qameta.allure.Attachment;

public class TestSetupTeardown implements ITestNGListener
{
    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        Configuration.reportsFolder = "target/allure-results";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );
        Selenide.open(String.format("http://%s:%s/%s",
                Config.HTTP_BASE_URL.value,
                Config.HTTP_BASE_PORT.value,
                Config.HTTP_BASE_PAGE.value
        ));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }

        closeBrowser();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return screenshot(OutputType.BYTES);
    }

    private void closeBrowser() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}

