package requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class GetRequest extends Common {
    Response response = null;
    //GET without auth
    public Response get(String endpoint) {
        try {
            response = RestAssured.given().get(endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //GET with auth
    public Response get(String endpoint, String username, String password) {
        try {
            response = RestAssured.given().auth().preemptive()
                    .basic(username, password).get("/user/repos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //POST with auth
    public Response post(String endpoint, String username, String password) {
        for(int i=0; i<3; i++) {
            String generatedString = "repo_"+RandomStringUtils.randomAlphanumeric(10);

            JSONObject postParams = new JSONObject();
            postParams.put("name", generatedString);
            postParams.put("description", "Intellij run");
            postParams.put("private", false);
            postParams.put("visibility", "public");
            try {
                response = RestAssured.given().auth().preemptive().basic(username, password)
                        .body(postParams.toJSONString()).post(endpoint);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }



}
