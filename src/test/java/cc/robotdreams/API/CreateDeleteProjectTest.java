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
public class CreateDeleteProjectTest
{
    @Description("Create new project by API")
    @Test(groups = "api-tests")
    public void createNewProject()
    {
        String text = JsonRequestGenerator.generateRandomTitle();
        CreateProject projectNameAndDesc = new CreateProject(text, text);
        String method = "createProject";
        Root requestBody = new Root(method, projectNameAndDesc);

        CreateProjectResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(CreateProjectResponse.class);

        TestData.PROJECT_ID = response.getResult();
    }

    @Description("Connect the user to the project by API")
    @Test(groups = "api-tests")
    public void addProjectUser()
    {
        Object[] value = {TestData.PROJECT_ID, TestData.USER_ID, "project-owner"};
        System.out.println(value);
        String method = "addProjectUser";
        Root requestBody = new Root(method, value);
        System.out.println(requestBody.getParams());

        AddProjectToUserResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(AddProjectToUserResponse.class);

        Assert.assertEquals(response.isResult(), true, "Project is not added to the User");
    }

    @Description("Delete project by API")
    @Test(groups = "api-tests")
    public void deleteProject()
    {
        DeleteProject id = new DeleteProject(TestData.PROJECT_ID);
        String method = "removeProject";
        Root requestBody = new Root(method, id);

        DeleteProjectResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(DeleteProjectResponse.class);

        Assert.assertEquals(response.isResult(), true, "Project is not deleted");
    }

}
