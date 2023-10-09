package cc.robotdreams.utils;

public enum TestData
{
    USER_NAME("James4"),
    PASSWORD("bond007"),
    PROJECT_NAME("Automation"),
    PROJECT_DESCRIPTION("Test project"),
    TASK_NAME("Just task"),
    TASK_DESCRIPTION("Test task"),
    COMMENT_TEXT("New comment");



    String value;
    TestData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
