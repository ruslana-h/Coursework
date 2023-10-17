package cc.robotdreams.API.POJO;


import java.util.List;

public class AddProjectToUser
{
    private List<String> params;

    public AddProjectToUser(List<String> params) {
        this.params = params;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
