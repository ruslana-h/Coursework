package cc.robotdreams.kanboard.api.POJO;

public class DeleteTaskResponse
{
    private String jsonrpc;
    private int id;
    private boolean result;

    public DeleteTaskResponse(String jsonrpc, int id, boolean result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public DeleteTaskResponse() {
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
