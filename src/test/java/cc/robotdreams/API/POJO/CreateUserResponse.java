package cc.robotdreams.API.POJO;



public class CreateUserResponse
{
    private String jsonrpc;
    private int id;
    private int result;

    public CreateUserResponse(String jsonrpc, int id, int result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public CreateUserResponse() {

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

    public void setResult(int result) {
        this.result = result;
    }
}
