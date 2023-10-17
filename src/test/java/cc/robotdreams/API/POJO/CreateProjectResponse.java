package cc.robotdreams.API.POJO;

public class CreateProjectResponse
{
    private String jsonrpc;
    private int id;
    private int result;

    public CreateProjectResponse(String jsonrpc, int id, int result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public CreateProjectResponse() {
    }

    public int getResult() {
        return result;
    }
}
