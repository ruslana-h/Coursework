package cc.robotdreams.kanboard.api.POJO;

public class CreateTaskResponse
{
    private String jsonrpc;
    private int id;
    private int result;

    public CreateTaskResponse(String jsonrpc, int id, int result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public CreateTaskResponse() {
    }

    public int getResult() {
        return result;
    }
}
