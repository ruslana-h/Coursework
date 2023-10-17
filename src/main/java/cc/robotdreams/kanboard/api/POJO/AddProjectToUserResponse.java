package cc.robotdreams.kanboard.api.POJO;

public class AddProjectToUserResponse
{
    private String jsonrpc;
    private int id;
    private boolean result;

    public AddProjectToUserResponse(String jsonrpc, int id, boolean result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public AddProjectToUserResponse() {
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public int getId() {
        return id;
    }

    public boolean isResult() {
        return result;
    }
}
