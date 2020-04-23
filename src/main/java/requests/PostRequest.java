package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class PostRequest extends Common {
    Response response = null;
    public Response post(String endpoint, String username, String password, JSONObject bodyParams) {
        try {
            response = RestAssured.given().auth().preemptive().basic(username, password)
                    .body(bodyParams.toJSONString()).post(endpoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return response;
    }
}
