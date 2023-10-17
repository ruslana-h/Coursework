package cc.robotdreams.API.POJO;

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

    public boolean isResult() {
        return result;
    }
}
