package Tests;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LocalAPITesting
{
    @Test(priority = 1)
    public void GET_Request()
    {
        baseURI = "http://localhost:3000";

        given().get("/users").then().statusCode(200).log().all();
    }

    @Test(priority = 2)
    public void POST_Request()
    {
        JSONObject request = new JSONObject();
        request.put("first name","OOP");
        request.put("last name","JAVA");
        request.put("subject id","010");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users/").
                then().
                statusCode(201);
    }

    @Test(priority = 3)
    public void PUT_Request()
    {
        JSONObject request = new JSONObject();
        request.put("first name","ABC");
        request.put("last name","DEF");
        request.put("subject id","6");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/10").
                then().
                statusCode(200);
    }

    @Test(priority = 4)
    public void PATCH_Request()
    {
        JSONObject request = new JSONObject();
        request.put("last name","ZZZ");

        baseURI = "http://localhost:3000";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/13").
                then().
                statusCode(200);
    }

    @Test(priority = 5)
    public void DELETE_Request()
    {
        baseURI = "http://localhost:3000";

        given().
                when().
                delete("/users/18").
                then().
                statusCode(200);
   }
}
