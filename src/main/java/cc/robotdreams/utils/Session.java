package cc.robotdreams.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class Session {
    private static final ThreadLocal<Session> _instance = ThreadLocal.withInitial(Session::new);

    private Session() {
        Configuration.timeout = 3000; // Set the default timeout for Selenide operations (in milliseconds)
        Configuration.browserSize = "1280";
        Configuration.browser = "chrome";
        Configuration.headless = Config.WEB_BROWSER_NO_GUI.isTrue();
        Configuration.reportsFolder = "target/allure-results";

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("wm-window-animations-disabled");
        options.addArguments("ash-disable-smooth-screen-rotation");
        options.addArguments("disable-smooth-scrolling");
        options.addArguments("disable-infobars");
        options.addArguments("disable-default-apps");
        options.addArguments("disable-extensions");
        //options.addArguments("lang=en_US");
        options.setAcceptInsecureCerts(true);
        //options.addArguments("auto-open-devtools-for-tabs");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "load-extension"});
        if (Config.WEB_BROWSER_NO_GUI.isTrue()) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
        }
        Configuration.browserCapabilities = options;

        // Configure WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Set up ChromeDriver
        WebDriverRunner.setWebDriver(Selenide.page());

        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    public static Session get() {
        return _instance.get();
    }

    public void close() {
        Selenide.closeWebDriver();
    }

    public void open(String url) {
        Selenide.open(url);
    }


}
