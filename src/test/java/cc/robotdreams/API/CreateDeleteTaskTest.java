package cc.robotdreams.API;

import cc.robotdreams.kanboard.api.JsonRequestGenerator;
import cc.robotdreams.kanboard.api.POJO.*;
import cc.robotdreams.kanboard.api.TestData;
import cc.robotdreams.utils.Config;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("API tests")
public class CreateDeleteTaskTest
{
    //static int taskId;
    @Description("Create new task by API")
    @Test(groups = "api-tests")
    public void createNewTask()
    {
        CreateTaskParams params = new CreateTaskParams(JsonRequestGenerator.generateRandomTitle(), TestData.PROJECT_ID);
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
        TestData.TASK_ID = response.getResult();
        Assert.assertEquals(response.getResult(), false, "Task is not created");
    }
    @Description("Delete the task by API")
    @Test(groups = "api-tests")
    public void deleteTask()
    {
        DeleteTaskParams params = new DeleteTaskParams(TestData.TASK_ID);
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
