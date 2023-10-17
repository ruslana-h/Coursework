package cc.robotdreams.API.POJO;

public class CreateTaskParams
{
    private int owner_id;
    private int creator_id;
    private String date_due;
    private String description;
    private int category_id;
    private int score;
    private String title;
    private int project_id;
    private String color_id;
    private int column_id;
    private int recurrence_status;
    private int recurrence_trigger;
    private int recurrence_factor;
    private int recurrence_timeframe;
    private int recurrence_basedate;

    public CreateTaskParams(String title, int project_id) {
        this.title = title;
        this.project_id = project_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
