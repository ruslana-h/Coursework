package cc.robotdreams.kanboard.api.POJO;

public class CreateProject
{
    private String name;
    private String description;

    public CreateProject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
