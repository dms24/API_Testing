package repos;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import requests.DeleteRequest;
import requests.GetRequest;
import requests.PostRequest;

import java.util.ArrayList;
import java.util.Random;

public class GetRepos {
    GetRequest getRequest = null;
    String generatedRepoName= RandomStringUtils.randomAlphanumeric(10);
    @BeforeMethod
    public  void  setup(){
        getRequest = new GetRequest();
    }
    @BeforeClass
    public void setupClass(){
        JSONObject body = Utils.createRepoParams(generatedRepoName,"beforeClassRepo", false,"public");
        new PostRequest().post("/user/repos","dms24","P@000mnb;;''asd",body);
    }
    @AfterClass
    public void tearDown(){

        new DeleteRequest().delete("/repos/dms24/"+generatedRepoName,"dms24","P@000mnb;;''asd");
    }
    @Test
    public void getPublicRepos(){
        Response response = getRequest.get("/users/dms24/repos");
        ArrayList reposNames = getRequest.responseToJsonPath(response).get("name");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(reposNames.contains("gitPractice"),true);
    }
    @Test
    public void getAllReposAuth(){
        Response response = getRequest.get("/user/repos","dms24","P@000mnb;;''asd");
        ArrayList repoLogins = getRequest.responseToJsonPath(response).get("name");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(repoLogins.contains("selenium-automation"),true);
    }
    @Test
    public void getRepo(){
        Response response = getRequest.get("/repos/dms24/"+generatedRepoName);
        Assert.assertEquals(response.getStatusCode(),200);
        String actualName=getRequest.responseToJsonPath(response).get("name");
        Assert.assertEquals(actualName,generatedRepoName);
    }
}
