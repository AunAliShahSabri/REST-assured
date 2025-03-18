package Tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

public class Test02_POST
{
    @Test
    public void test01()
    {
//        Map<String,Object> map = new HashMap<String, Object>(); //used to send request payloads (for POST or PUT requests) and handle response data.
//        map.put("name","Aun"); //creating json request payload
//        map.put("job","None");
//        System.out.println(map);
//        JSONObject request = new JSONObject(map); //mapping the payload in json format

        //can be used this way also after using JSON library.
        //doing this for getting response in json format
        JSONObject request = new JSONObject();
        request.put("name","Aun"); //creating json request payload
        request.put("job","None");
        System.out.println(request.toJSONString());

        baseURI ="https://reqres.in/api";
        given().
                header("content-Type","application/json"). //use this header
                contentType(ContentType.JSON). //or use this. sending server request json type
                accept(ContentType.JSON). //accepting request json type
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();
    }
}
