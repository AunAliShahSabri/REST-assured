package Tests;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test03_PUTPATCHDELETE
{
    @Test
    public void testPut()
    {
        JSONObject request = new JSONObject();
        request.put("name", "Aun");
        request.put("job", "none");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                header("content-Type","application/json"). //use this header
                contentType(ContentType.JSON). //or use this. sending server request json type
                accept(ContentType.JSON). //accepting request json type
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void testPatch()
    {
        JSONObject request = new JSONObject();
        request.put("name", "Aun");
        request.put("job", "none");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";

        given().
                header("content-Type","application/json"). //use this header
                contentType(ContentType.JSON). //or use this. sending server request json type
                accept(ContentType.JSON). //accepting request json type
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void testDelete()
    {
        baseURI = "https://reqres.in";
        when().
                delete("/api/users/2").
                then().
                statusCode(204).log().all();

    }
}
