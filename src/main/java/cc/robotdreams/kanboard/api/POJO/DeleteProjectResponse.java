package cc.robotdreams.kanboard.api.POJO;

public class DeleteProjectResponse
{
    private String jsonrpc;
    private int id;
    private boolean result;

    public DeleteProjectResponse() {
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
