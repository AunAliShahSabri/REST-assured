package Tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator
{
    @Test
    public void test01()
    {
        //create a schema.json file locally then add it in classes folder in the project.
        //Add maven dependency in pom file
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200);
    }
}
