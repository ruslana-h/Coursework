package cc.robotdreams.kanboard.api.POJO;

public class DeleteTaskParams
{
    private int task_id;

    public DeleteTaskParams(int task_id) {
        this.task_id = task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
}
