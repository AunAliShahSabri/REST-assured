package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DataDrivenTesting extends dataForTests
{

    @Test(dataProvider = "Data Provider")
    public void POSTMethod(String firstName, String lastName, int subjectId)
    {
        JSONObject request = new JSONObject();
        request.put("first name", firstName);
        request.put("last name", lastName);
        request.put("subject id", subjectId);

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

    //@Test(dataProvider = "DeleteData")
    public void DELETEMethod(int userId)
    {
        baseURI = "http://localhost:3000";

        given().
                when().
                delete("/users/"+userId).
                then().
                statusCode(200);
    }

    @Parameters("userid")
    @Test(dataProvider = "DeleteData")
    public void DELETEMethod02(int userId)
    {
        baseURI = "http://localhost:3000";

        given().
                when().
                delete("/users/"+userId).
                then().
                statusCode(200);
    }
}
