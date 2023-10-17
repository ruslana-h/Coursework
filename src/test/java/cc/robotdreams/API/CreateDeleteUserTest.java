package cc.robotdreams.API;

import cc.robotdreams.API.POJO.*;
import cc.robotdreams.kanboard.api.JsonRequestGenerator;
import cc.robotdreams.utils.Config;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("API tests")
public class CreateDeleteUserTest
{
    static int userId;
    @Description("Create new user by API")
    @Test(groups = "createUser", priority = 1)
    public void createNewUser()
    {
        String method = "createUser";
        CreateUser user = new CreateUser(JsonRequestGenerator.generateRandomName(),
                                         JsonRequestGenerator.generateRandomPassword());
        Root requestBody = new Root(method, user);

        CreateUserResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(CreateUserResponse.class);

        Assert.assertNotEquals(response.getResult(), false, "User is not created");
        userId = response.getResult();
        System.out.println(userId);

    }

    @Description("Delete the user by API")
    @Test(priority = 5)
    public void deleteUser()
    {
        DeleteUser id = new DeleteUser(userId);

        String method = "removeUser";
        Root requestBody = new Root(method, id);

        DeleteUserResponse response = given()
                .auth().basic(Config.BASE_USER_NAME.value, Config.BASE_USER_TOKEN.value)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Config.baseURI)
                .then()
                .statusCode(200)
                .extract().as(DeleteUserResponse.class);

        System.out.println(response.isResult());
        Assert.assertEquals(true, response.isResult(), "User is not deleted");
    }
}
