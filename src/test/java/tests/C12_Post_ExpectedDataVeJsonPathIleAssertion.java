package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

     /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body - Expected Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/

    @Test
    public void post01() {

        // 1 - Url ve Request Body hazirla

        String url = "https://restful-booker.herokuapp.com/booking";

        /*
                   {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
         */

        JSONObject bookingdates =  new JSONObject();

        bookingdates.put("checkin" , "2021-06-01").put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname" , "Ahmet").put("lastname" , "Bulut")
                .put("totalprice" , 500).put( "depositpaid" , false).put("additionalneeds" , "wi-fi")
                .put("bookingdates",bookingdates);

        // EXPECTED DATA PREPARE

        /*
        Response Body - Expected Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */

        JSONObject expData = new JSONObject();

        expData.put("bookingid",24).put("booking",reqBody);

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        JsonPath respJP = response.jsonPath();

        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));





    }
}
