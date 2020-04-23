//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.json.simple.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertEquals;
//
//public class testExample {
//
//    Response response = null;
//
//    public String getURI(){
//        return RestAssured.baseURI = "https://api.github.com";
//    }
//    public String setAuth(String authUser, String authPassword){
//        authUser="dms24";
//        authPassword="P@000mnb;;''asd";
//        RestAssured.given().auth().preemptive().basic(authUser,authPassword);
//    }
//    public int getStatusCode(){
//        return response.getStatusCode();
//    }
//    class Get{
//        @Test
//        public void getMethod(){
//            getURI();
//            JsonPath jsonPath;
//            try {
//                response = RestAssured.given().get("/users/dms24/repos");
//                jsonPath=response.jsonPath();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            assertEquals(getStatusCode(),200 );
//        }
//    }
//    class GetAuth{
//        @Test
//        public void getMethodAuth(){
//            RestAssured.baseURI = "https://api.github.com";
//            Response response = null;
//            JsonPath jsonPath;
//            try {
//                response = RestAssured.given().auth().preemptive().basic("dms24","P@000mnb;;''asd")
//                        .get("/user/repos");
//                jsonPath=response.jsonPath();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            int statusCode = response.getStatusCode();
//            assertEquals(response.getStatusCode(),200 );
//        }
//    }
//    class Post{
//        @Test
//        public void postMethod(){
//            RestAssured.baseURI = "https://api.github.com";
//            Response response = null;
//            JSONObject requestParams = new JSONObject();
//            requestParams.put("name","API_Intellij_3");
//            requestParams.put("description", "This is the new repository");
//            requestParams.put("homepage", "https://github.com");
//            requestParams.put("private", true);
//
//            response=RestAssured.given().auth().preemptive().basic("dms24","P@000mnb;;''asd")
//                    .body(requestParams.toJSONString()).post("/user/repos");
//            Assert.assertEquals(getStatusCode(), 201);
//        }
//    }
//    class Delete{
//        @Test
//        public void deleteMethod(){
//            RestAssured.baseURI = "https://api.github.com";
//            Response response = null;
//            response=RestAssured.given().auth().preemptive().basic("dms24","P@000mnb;;''asd")
//                    .delete("repos/dms24/API_Intellij");
//            int statusCode=response.getStatusCode();
//            Assert.assertEquals(statusCode,204);
//        }
//    }
//    class Put{
//        @Test
//        public void putMethod(){
//            RestAssured.baseURI = "https://api.github.com";
//            Response response = null;
//
//            JSONObject params = new JSONObject();
//            params.put("name","Test_API_Intellij");
//            params.put("description","Intellij run");
//            params.put("homepage","https://github.com");
//            params.put("private",false);
//            params.put("visibility","public");
//            params.put("has_issues",false);
//
//            response=RestAssured.given().auth().preemptive().basic("dms24","P@000mnb;;''asd")
//                    .body(params.toJSONString()).post("/repos/dms24/Test_API_Post_update");
//            int statusCode = response.getStatusCode();
//            Assert.assertEquals(statusCode,200);
//        }
//    }
//}
