package cc.robotdreams.API;

import cc.robotdreams.utils.Config;
import cc.robotdreams.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateDeleteTaskTest
{
    String taskId = null;
    @Test
    public void createNewTask()
    {
        int id = CreateDeleteProjectTest.projectId;
        //int user = CreateDeleteUserTest.userId;
        System.out.println(id);
        String taskName = TestData.TASK_NAME.getValue();
        String requestBody = "{"
                + "\"jsonrpc\": \"2.0\","
                + "\"method\": \"createTask\","
                + "\"id\": 1176509643,"
                + "\"params\": {"
                + "\"owner_id\": 32,"
                + "\"creator_id\": 32,"
                + "\"date_due\": \"2023-11-01\","
                + "\"description\": \"rrr\","
                + "\"category_id\": 2,"
                + "\"score\": 1,"
                + "\"title\": \"ggg\","
                + "\"project_id\": 37,"
                + "\"color_id\": \"green\","
                + "\"column_id\": 1,"
                + "\"recurrence_status\": 1,"
                + "\"recurrence_trigger\": 1,"
                + "\"recurrence_factor\": 1,"
                + "\"recurrence_timeframe\": 1,"
                + "\"recurrence_basedate\": 1"
                + "}"
                + "}";

        Response response = RestAssured.given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.getBody().asString());
        taskId = response.jsonPath().getString("result");
        System.out.println(taskId);
    }

    @Test
    public void deleteTask()
    {
        String requestBody = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"removeTask\",\n" +
                "    \"id\": 1423501287,\n" +
                "    \"params\": {\n" +
                "        \"task_id\": " + taskId + "\n" +
                "    }\n" +
                "}";

        Response response = RestAssured.given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.getBody().asString());
    }
}
