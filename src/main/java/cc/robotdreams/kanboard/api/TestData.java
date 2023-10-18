package cc.robotdreams.kanboard.api;

public class TestData
{
    public static final String USERNAME = JsonRequestGenerator.generateRandomName();
    public static final String PASSWORD = JsonRequestGenerator.generateRandomPassword();
    public static int USER_ID = 0;
    public static int PROJECT_ID = 0;
    public static int TASK_ID = 0;
    public static final String TASK_TITLE = JsonRequestGenerator.generateRandomTitle();
    public static final String TASK_DESC = JsonRequestGenerator.generateRandomTitle();
}
