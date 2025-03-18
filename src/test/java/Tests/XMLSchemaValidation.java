package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class XMLSchemaValidation
{
    @Test
    public void XMLValidation() throws IOException {
        // Ensure the SOAP request file exists
        File file = new File("./SOAPRequest/Add.xml"); //Add path of the created xml file
        if (file.exists())
            System.out.println("File exist");
        //FileInputStream is used for reading raw bytes from a file.
        FileInputStream fileInputStream = new FileInputStream(file);
        //getting the request body as string
        //IOUtils come from apache.commons(add dependency in pom file)
        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
        baseURI = "http://www.dneonline.com"; //Set base URI for SOAP service
        // Send SOAP request and capture the response
        Response response = given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().
                statusCode(200).
                extract().response();
        // Print SOAP response for debugging
        System.out.println("SOAP Response: \n" + response.asString());

        // Ensure response is not empty before validation
        if (response.asString().isEmpty()) {
            throw new RuntimeException("Error: Received an empty response from the SOAP server!");
        }

        // Validate XML schema
        given()
                .body(response.asString())
                .when()
                .then()
                .that().
                body(matchesXsdInClasspath("Calculator.xsd"));  // Ensure this file is in src/test/resources/
    }
}
