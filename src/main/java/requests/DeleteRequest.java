package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest extends Common {
    public Response delete(String endpoint, String username, String password){
        Response responseDelete = null;
        try{
            responseDelete= RestAssured.given().auth().preemptive().basic(username,password).delete(endpoint);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseDelete;
    }
}
