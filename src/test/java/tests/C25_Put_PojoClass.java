package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceRequestBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {

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

    Expected Body

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

        JsonPlaceRequestBodyPOJO reqBody = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        JsonPlaceRequestBodyPOJO expData = new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).when().body(reqBody).put("/{pp1}/{pp2}");

        JsonPlaceRequestBodyPOJO responsePojo = response.as(JsonPlaceRequestBodyPOJO.class);

        assertEquals(expData.getTitle(),responsePojo.getTitle());
        assertEquals(expData.getBody(),responsePojo.getBody());
        assertEquals(expData.getId(),responsePojo.getId());
        assertEquals(expData.getUserId(),responsePojo.getUserId());










    }


}
