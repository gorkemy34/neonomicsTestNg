package ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import neonomics.utilities.ConfigReader;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class GetAccount {

    @Test
    public static Response getAuth() {

        RestAssured.baseURI= ConfigReader.getProperty("auth_link");

        Map<String,String > parameters = new HashMap<String, String>();
        parameters.put("client_id",ConfigReader.getProperty("clientId"));
        parameters.put("client_secret",ConfigReader.getProperty("clientSecret"));
        parameters.put("grant_type","client_credentials");
        parameters.put("scope", "banqbridge_client");
        parameters.put("ContentType" , "application/x-www-form-urlencoded");


        Response response = given().contentType("application/x-www-form-urlencoded").
                accept("*/*").
                formParams(parameters).
                when().when().post();

        return response;

    }

    @Test
    public static String getSupportBank(){

        String url ="https://sandbox.neonomics.io/ics/v3/banks";

        String access = "Bearer "+getAuth().path("access_token");


        Map<String,String > parameters = new HashMap<String, String>();
        parameters.put("authorization",access);
        parameters.put("accept","application/json");
        parameters.put("x-device-id","19AA285F-75E0-4D9A-8B5C-83524AD266FE");

        Response response = given().headers(parameters).get(url);

        String bank_Id = response.path("find {it.bankDisplayName ==\"Justo Bank\"}.id");

        return bank_Id;

    }

    @Test
    public static String createSession(){

        String url ="https://sandbox.neonomics.io/ics/v3/session";

        String access = "Bearer "+getAuth().path("access_token");
        String bankId = getSupportBank();

        Map<String,String > parameters = new HashMap<String, String>();
        parameters.put("authorization",access);
        parameters.put("accept","application/json");
        parameters.put("content-type","application/json");
        parameters.put("x-device-id","19AA285F-75E0-4D9A-8B5C-83524AD266FE");

        Map<String,String> bnkId=new HashMap<>();
        bnkId.put("bankId",bankId);
        Response response = given().headers(parameters).body(bnkId).post(url);

        String sessionId = response.path("sessionId");

        return sessionId;

    }

    @Test
    public void getAccount(){

        String url ="https://sandbox.neonomics.io/ics/v3/accounts";

        String access = "Bearer "+getAuth().path("access_token");

        Map<String,String > parameters = new HashMap<String, String>();
        parameters.put("authorization",access);
        parameters.put("accept","application/json");
        parameters.put("x-device-id","19AA285F-75E0-4D9A-8B5C-83524AD266FE");
        parameters.put("x-psu-id","AQf3CuTr6q1uM0PtiztUpyTmlhAiu6JWEpUlSn0A/qUa7xQILOolKu4=");
        parameters.put("x-psu-ip-address","109.74.179.3");
        parameters.put("x-session-id","adcde3e9-98f7-4553-8e2e-7dab7f1d3586");

        Response response = given().headers(parameters).get(url);

        response.prettyPrint();
    }
}



