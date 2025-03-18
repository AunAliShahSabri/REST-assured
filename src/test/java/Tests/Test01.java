package Tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test01
{
    @Test
    public void test01()
    {
        //Using Response class variable to store the response of Get request
        Response response = get("https://reqres.in/api/users?page=2"); //Rest Assured is a class using get method to run a get request.

        System.out.println(response.getStatusCode()); //get status code of request and print
        System.out.println(response.getTime()); //get response time and print
        System.out.println(response.getBody().asString()); //get response body and print it as string
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getCookies());


        int statusCode = response.getStatusCode();  //get status code and store it in variable
        Assert.assertEquals(statusCode, 200);   //verify code equals to expected value

    }

    @Test
    public void test02()
    {
        baseURI = "https://reqres.in/api"; //used baseURI because of static import added in the start
        given().get("/users?page=2"). //hitting the end point of request
                then().statusCode(200). //getting status code of the request
                body("data[1].id", equalTo(8)) //validating id=8 from the json of the request
                .log().all(); //printing the whole response body
    }

    @Test
    public void test03()
    {
        baseURI = "https://reqres.in/api/";
        given().get("users/2").
                then().statusCode(200).
                body("data.email", equalTo("janet.weaver@reqres.in")).
                log().all();
    }

    @Test
    public void test04()
    {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").
                then().statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name", hasItems("George","Rachel")); //verifying collection contains items mentioned.
    }
}
