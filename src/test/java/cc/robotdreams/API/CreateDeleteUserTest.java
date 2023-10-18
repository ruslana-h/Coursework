package cc.robotdreams.API;

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
public class CreateDeleteUserTest
{
    @Description("Create new user by API")
    @Test(groups = "api-tests")
    public void createNewUser()
    {
        String method = "createUser";
        CreateUser user = new CreateUser(TestData.USERNAME, TestData.PASSWORD);
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
        TestData.USER_ID = response.getResult();
    }

    @Description("Delete the user by API")
    @Test(groups = "api-tests")
    public void deleteUser()
    {
        DeleteUser id = new DeleteUser(TestData.USER_ID);

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

        Assert.assertEquals(response.isResult(), true, "User is not deleted");
    }
}
