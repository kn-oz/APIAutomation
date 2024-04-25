package testData;

import org.json.JSONObject;

public class TestDataJsonPlace {

    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8";
    public String connectionHeader = "keep-alive";



    public JSONObject expectedBodyOlusturJson(){

        JSONObject expData = new JSONObject();

        expData.put("userId",3)
                .put("id",22)
                .put("title","dolor sint quo a velit explicabo quia nam")
                .put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
    }

    public JSONObject requestBodyOlusturJson(){

        JSONObject reqBody = new JSONObject();

        reqBody.put("title","Ali")
                .put("body","Merhaba")
                .put("userId",10)
                .put("id",70);

        return reqBody;
    }
}
