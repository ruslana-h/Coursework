package cc.robotdreams.kanboard.api.POJO;

public class DeleteUser
{
    private int user_id;

    public DeleteUser(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
