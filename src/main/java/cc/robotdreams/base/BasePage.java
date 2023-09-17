package cc.robotdreams.base;

import cc.robotdreams.utils.Session;
import org.openqa.selenium.WebDriver;

abstract public class BasePage
{
    protected WebDriver wd() {
        return (WebDriver) Session.get();
    }
}
