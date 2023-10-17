package cc.robotdreams.kanboard.api.POJO;

public class DeleteUserResponse
{
    private String jsonrpc;
    private int id;
    private boolean result;

    public DeleteUserResponse(String jsonrpc, int id, boolean result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public DeleteUserResponse() {

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
