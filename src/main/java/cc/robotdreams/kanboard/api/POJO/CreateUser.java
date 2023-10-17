package cc.robotdreams.kanboard.api.POJO;


public class CreateUser
{
    private static String username;
    private static String password;

    public CreateUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
