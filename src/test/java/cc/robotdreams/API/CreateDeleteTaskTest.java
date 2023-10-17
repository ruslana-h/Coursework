package cc.robotdreams.API;

import cc.robotdreams.API.POJO.*;
import cc.robotdreams.kanboard.api.JsonRequestGenerator;
import cc.robotdreams.utils.Config;
import cc.robotdreams.utils.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("API tests")
public class CreateDeleteTaskTest
{
    static int taskId;
    @Description("Create new task by API")
    @Test
    public void createNewTask()
    {
        int id = CreateDeleteProjectTest.projectId;
        System.out.println(id);
        CreateTaskParams params = new CreateTaskParams(JsonRequestGenerator.generateRandomTitle(), id);
        String method = "createTask";
        Root requestBody = new Root(method, params);

        CreateTaskResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(CreateTaskResponse.class);

        System.out.println(response.getResult());
        taskId = response.getResult();
        Assert.assertEquals(response.getResult(), false, "Task is not created");
    }
    @Description("Delete the task by API")
    @Test
    public void deleteTask()
    {
        DeleteTaskParams params = new DeleteTaskParams(taskId);
        String method = "removeTask";
        Root requestBody = new Root(method, params);

        DeleteTaskResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(DeleteTaskResponse.class);

        System.out.println(response.isResult());
        Assert.assertEquals(true, response.isResult(), "The task is not deleted");
    }
}
