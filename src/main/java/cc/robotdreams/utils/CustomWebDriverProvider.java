package cc.robotdreams.utils;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public abstract class CustomWebDriverProvider implements WebDriverProvider {
    public WebDriver createDriver() {
        String browser = Config.WEB_BROWSER.value;
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = getCommonChromeOptions();
            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = getCommonFirefoxOptions();
            return new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }
    }

    public ChromeOptions getCommonChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("wm-window-animations-disabled");
        options.addArguments("ash-disable-smooth-screen-rotation");
        options.addArguments("disable-smooth-scrolling");
        options.addArguments("disable-infobars");
        options.addArguments("disable-default-apps");
        options.addArguments("disable-extensions");
        options.addArguments("disable-gpu");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("lang=en_US");
        options.setAcceptInsecureCerts(true);
        options.addArguments("auto-open-devtools-for-tabs");
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("history.saving_disabled", true);
        preferences.put("browser.show_home_button", false);
        preferences.put("credentials_enable_service", false);
        preferences.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", preferences);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "load-extension"});

        if (Config.WEB_BROWSER_NO_GUI.isTrue()) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
        }

        options.addArguments("--window-size=" + Config.BROWSER_WIN_WIDTH.value + "," + Config.BROWSER_WIN_HEIGHT.value + "");
        return options;
    }

    public FirefoxOptions getCommonFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("app.update.disabledForTesting", true);
        options.setCapability("toolkit.cosmeticAnimations.enabled", false);
        options.setCapability("datareporting.policy.dataSubmissionPolicyAccepted", false);
        options.addArguments("-width=" + Config.BROWSER_WIN_WIDTH.value);
        options.addArguments("-height=" + Config.BROWSER_WIN_HEIGHT.value);
        options.setHeadless(Config.WEB_BROWSER_NO_GUI.isTrue());
        return options;
    }


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return null;
    }
}
