package cc.robotdreams.base;

import cc.robotdreams.utils.CustomWebDriverProvider;
import com.codeborne.selenide.Configuration;

abstract public class BasePage
{
    protected String wd() {
        return Configuration.browser = CustomWebDriverProvider.class.getName();
    }
}
