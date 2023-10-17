package cc.robotdreams.API;

import cc.robotdreams.API.POJO.*;
import cc.robotdreams.kanboard.api.JsonRequestGenerator;
import cc.robotdreams.utils.Config;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Feature("API tests")
public class CreateDeleteProjectTest
{
    static int projectId;
    @Description("Create new project by API")
    @Test()
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

        projectId = response.getResult();
    }

    @Description("Connect the user to the project by API")
    @Test
    public void addProjectUser()
    {
        List<String> value = new ArrayList<>();
        value.add(String.valueOf(projectId));
        value.add(String.valueOf(CreateDeleteUserTest.userId));
        value.add("project-viewer");
        //AddProjectToUser params = new AddProjectToUser(value);
        System.out.println(value);
        String method = "addProjectUser";
        Root requestBody = new Root(method, value);

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
    @Test()
    public void deleteProject()
    {
        DeleteProject id = new DeleteProject(projectId);
        String method = "removeProject";
        Root requestBody = new Root(method, id.toString());

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
