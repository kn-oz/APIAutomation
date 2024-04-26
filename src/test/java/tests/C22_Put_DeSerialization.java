package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataJsonPlace;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
   @Test
    public void put01(){

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

       HashMap<String,Object> reqBody = testDataJsonPlace.requestbodyOlusturMap();

       HashMap<String,Object> expData = testDataJsonPlace.requestbodyOlusturMap();

       Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody)
               .put("/{pp1}/{pp2}");

       //response.prettyPrint();

       HashMap<String,Object> respMap = response.as(HashMap.class);

       Assert.assertEquals(expData.get("title"),respMap.get("title"));
       Assert.assertEquals(expData.get("body"),respMap.get("body"));
       Assert.assertEquals(expData.get("userId"),respMap.get("userId"));
       Assert.assertEquals(expData.get("id"),respMap.get("id"));




    }
}
