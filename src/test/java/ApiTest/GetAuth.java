package ApiTest;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import neonomics.utilities.ConfigReader;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class GetAuth {

    @Test
    public void getAuth () {

        RestAssured.baseURI= ConfigReader.getProperty("auth_link");

        Map<String,String > parameters = new HashMap<String, String>();
        parameters.put("client_id",ConfigReader.getProperty("clientId"));
        parameters.put("client_secret",ConfigReader.getProperty("clientSecret"));
        parameters.put("grant_type","client_credentials");
        parameters.put("scope", "banqbridge_client");
        parameters.put("ContentType" , "application/x-www-form-urlencoded");


        Response response = given().accept(ContentType.JSON).headers(parameters).post();

        System.out.println(response.prettyPrint());






    }




}
