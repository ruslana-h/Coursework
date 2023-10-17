package cc.robotdreams.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.annotation.Nonnull;

public class CustomWebDriverProvider implements WebDriverProvider {
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("wm-window-animations-disabled");
        options.addArguments("ash-disable-smooth-screen-rotation");
        options.addArguments("disable-smooth-scrolling");
        options.addArguments("disable-infobars");
        options.addArguments("disable-default-apps");
        options.addArguments("disable-extensions");
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);

        if (Config.WEB_BROWSER_NO_GUI.isTrue()) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
        }
        WebDriver driver = new ChromeDriver(options);
        Configuration.browserCapabilities = options;
        // options.addArguments("--headless");

            return driver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("wm-window-animations-disabled");
            options.addArguments("ash-disable-smooth-screen-rotation");
            options.addArguments("disable-smooth-scrolling");
            options.addArguments("disable-infobars");
            options.addArguments("disable-default-apps");
            options.addArguments("disable-extensions");
            options.addArguments("--start-maximized");
            WebDriver driver = new FirefoxDriver(options);
            Configuration.browserCapabilities = options;

            return driver;
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }

    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return null;
    }


}
