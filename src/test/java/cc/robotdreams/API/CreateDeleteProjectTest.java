package cc.robotdreams.API;

import cc.robotdreams.utils.Config;
import cc.robotdreams.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDeleteProjectTest
{

    static int projectId;
    @Test(groups = "createProject", priority = 2)
    public void createNewProject()
    {
        String projectName = TestData.PROJECT_NAME.getValue();
        String projectDescription = TestData.PROJECT_DESCRIPTION.getValue();
        String requestBody = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"createProject\",\n" +
                "    \"id\": 1797076613,\n" +
                "    \"params\": {\n" +
                "        \"name\": \"" + projectName + "\",\n" +
                "        \"description\": \"" + projectDescription + "\"\n" +
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
        projectId = response.jsonPath().getInt("result");
    }

    @Test
    public void addProjectUser()
    {
        System.out.println(projectId + CreateDeleteUserTest.userId);
        String requestBody = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"addProjectUser\",\n" +
                "    \"id\": 1797076613,\n" +
                "    \"params\": [\n" +
                "        \"" + projectId + "\",\n" +
                "        \"" + CreateDeleteUserTest.userId + "\",\n" +
                "        \"project-editor\"\n" +
                "    ]\n" +
                "}\n";

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
//        String result = response.jsonPath().getString("result");
//        Assert.assertEquals(result, true, "Project is not added to the User");
    }

    @Test(dependsOnGroups = "createTask", priority = 5)
    public void deleteProject()
    {
        String requestBody = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"removeProject\",\n" +
                "    \"id\": 46285125,\n" +
                "    \"params\": {\n" +
                "        \"project_id\": \"" + projectId + "\"\n" +
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
        System.out.println("Id " + projectId);
    }

//    @Test(groups = "createProjectForLoggedUser")
//    public void createProjectForLoggedUser()
//    {
//        String requestBody = "{\n" +
//                "    \"jsonrpc\": \"2.0\",\n" +
//                "    \"method\": \"createMyPrivateProject\",\n" +
//                "    \"id\": 12367,\n" +
//                "    \"params\": [\n" +
//                "        \"my project\"\n" +
//                "    ]\n" +
//                "}";
//
//        Response response = RestAssured.given()
//                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .when()
//                .post(Config.baseURI)
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//
//        System.out.println(response.getBody().asString());
//        int privateProjectId = response.jsonPath().getInt("result");
//        System.out.println(privateProjectId);
//
//    }

}
