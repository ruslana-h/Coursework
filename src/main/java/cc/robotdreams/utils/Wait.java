package cc.robotdreams.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Instant;

public class Wait {
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Throwable e) {
            /* Ignore */
        }
    }

    public static void waitWhilePageIsLoading() {
        long timeoutInSeconds = Instant.now().getEpochSecond() + 30;

        while (Instant.now().getEpochSecond() <= timeoutInSeconds) {
            boolean isPageLoaded = (boolean) ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                    .executeScript("return document.readyState === 'complete';");

            if (isPageLoaded) {
                return;
            }

            sleep(3000); // Sleep for 1 second before checking again
        }

        throw new RuntimeException("Page loading takes a lot of time");
    }
}

