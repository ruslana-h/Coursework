package cc.robotdreams.kanboard.api.POJO;

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

    public String getJsonrpc() {
        return jsonrpc;
    }

    public int getId() {
        return id;
    }

    public int getResult() {
        return result;
    }
}
