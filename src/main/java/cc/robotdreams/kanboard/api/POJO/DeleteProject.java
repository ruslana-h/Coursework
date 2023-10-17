package cc.robotdreams.kanboard.api.POJO;

public class DeleteProject
{
    private int project_id;

    public DeleteProject(int project_id) {
        this.project_id = project_id;
    }

    public int getProject_id() {
        return project_id;
    }

}
