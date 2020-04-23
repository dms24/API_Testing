package requests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class Common {
    public Common(){
        RestAssured.baseURI = "https://api.github.com";
    }
    public JsonPath responseToJsonPath(Response response){
        return response.getBody().jsonPath();
    }
}
