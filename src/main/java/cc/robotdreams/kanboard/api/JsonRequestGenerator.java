package cc.robotdreams.kanboard.api;

import cc.robotdreams.utils.DataForTest;
import org.apache.commons.lang3.RandomStringUtils;

public class JsonRequestGenerator {
    public static String generateRandomTitle()
    {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static String generateRandomName()
    {
        return RandomStringUtils.randomAlphabetic(5, 10);
    }

    public static String generateRandomPassword()
    {
        return RandomStringUtils.randomAlphanumeric(8);
    }

}
