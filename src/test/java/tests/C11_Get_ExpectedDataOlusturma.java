package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {

     /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz

   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void expectedData(){

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // EXPECTED DATA PREPERATION

        JSONObject expData = new JSONObject();

        expData.put("userId",3).put("id",22).put("title","dolor sint quo a velit explicabo quia nam")
                .put("body","eos qui et ipsum ipsam suscipit aut sed omnis non odio expedita earum mollitia molestiae aut atque rem suscipit nam impedit esse");



        Response response = given().when().get(url);

        JsonPath responseJP= response.jsonPath();

        Assert.assertEquals(expData.get("userId"),responseJP.get("userId"));
        Assert.assertEquals(expData.get("id"),responseJP.get("id"));
        Assert.assertEquals(expData.get("title"),responseJP.get("title"));





    }


}
