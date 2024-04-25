package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data

        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */

    @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

        JSONObject reqbody = testDataJsonPlace.requestBodyOlusturJson();

        JSONObject expData = testDataJsonPlace.requestBodyOlusturJson();

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().
                body(reqbody.toString()).put("/{pp1}/{pp2}");

        JsonPath respJP = response.jsonPath();

        Assert.assertEquals(expData.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expData.get("id"),respJP.get("id"));
        Assert.assertEquals(expData.get("title"),respJP.get("title"));
        Assert.assertEquals(expData.get("body"),respJP.get("body"));

        Assert.assertEquals(testDataJsonPlace.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlace.contentType,response.getContentType());
        Assert.assertEquals(testDataJsonPlace.connectionHeader,response.getHeader("Connection"));



    }


}
