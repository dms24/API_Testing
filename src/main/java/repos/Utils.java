package repos;

import org.json.simple.JSONObject;

public class Utils {
    public static JSONObject createRepoParams(String name,String description,boolean isPrivate, String visibility){
        JSONObject postParams = new JSONObject();
        postParams.put("name", name);
        postParams.put("description", description);
        postParams.put("private", isPrivate);
        postParams.put("visibility", visibility);
        return postParams;
    }

}
