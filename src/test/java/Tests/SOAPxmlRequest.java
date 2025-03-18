package Tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class SOAPxmlRequest
{
    @Test
    public void validateSOAPXML() throws IOException {
        //To get request body from a file, create a file with xml extension and use it in code
        File file = new File("./SOAPRequest/Add.xml"); //Add path of the created xml file
        if (file.exists())
            System.out.println("File exist");
        //FileInputStream is used for reading raw bytes from a file.
        FileInputStream fileInputStream = new FileInputStream(file);
        //getting the request body as string
        //IOUtils come from apache.commons(add dependency in pom file)
        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
        baseURI = "http://www.dneonline.com";
        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().
                statusCode(200).
                log().all().
                and().
                body("//*:AddResult.text()", equalTo("6"));
    }
}
