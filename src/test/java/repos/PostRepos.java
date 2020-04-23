package repos;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.GetRequest;
import requests.PostRequest;

public class PostRepos {
    PostRequest postRequest = null;
    @BeforeMethod
    public  void  setup(){
        postRequest = new PostRequest();
    }
    @Test
    public void postReposAuth(){

       // Response response = postRequest.post("/user/repos","dms24","P@000mnb;;''asd",);
    }
}
