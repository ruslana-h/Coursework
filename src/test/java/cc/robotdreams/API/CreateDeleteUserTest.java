package cc.robotdreams.API;

import cc.robotdreams.utils.Config;
import cc.robotdreams.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateDeleteUserTest
{
    static int userId;
    @Test(groups = "createUser", priority = 1)
    public void createNewUser()
    {
        String userName = TestData.USER_NAME.getValue();
        String userPassword = TestData.PASSWORD.getValue();
        String requestBody = "{"
                + "\"jsonrpc\": \"2.0\","
                + "\"method\": \"createUser\","
                + "\"id\": \"124\","
                + "\"params\": {"
                + "\"username\": \"" + userName + "\","
                + "\"password\": \"" + userPassword + "\""
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
        userId = response.jsonPath().getInt("result");
        System.out.println("Username: " + userName);
        System.out.println("Password: " + userPassword);
        System.out.println("id: " + userId);


    }


    @Test(priority = 5)
    public void deleteUser()
    {
        System.out.println("User ID: " + userId);
        String requestBody = "{"
                + "\"jsonrpc\": \"2.0\","
                + "\"method\": \"removeUser\","
                + "\"id\": 1,"
                + "\"params\": {"
                + "\"user_id\":" + userId
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
        System.out.println("id: " + userId);
    }
}
