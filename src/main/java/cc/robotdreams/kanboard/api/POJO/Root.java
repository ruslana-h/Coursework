package cc.robotdreams.kanboard.api.POJO;

public class Root
{
    private String jsonrpc = "2.0";
    private String method;
    private int id = 1518863034;
    private Object params;

    public Root(String method, Object params) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.id = id;
        this.params = params;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public int getId() {
        return id;
    }

    public Object getParams() {
        return params;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
