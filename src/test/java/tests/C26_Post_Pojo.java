package tests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingPOJO;
import pojos.BookingdatesPOJO;
import pojos.BookingdatesPOJO;
import pojos.HerokuappExpBodyPOJO;

import static io.restassured.RestAssured.given;

public class C26_Post_Pojo extends HerokuAppBaseUrl {

     /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-01"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post(){

        // URL & REQBODY CREATION

        specHerokuApp.pathParam("pp1","booking");

        BookingdatesPOJO bookingdates = new BookingdatesPOJO("2021-06-01","2021-06-01");

        BookingPOJO reqbody = new BookingPOJO("Ali","Bak",500,false,bookingdates,"wi-fi");

        HerokuappExpBodyPOJO expData = new HerokuappExpBodyPOJO(24,reqbody);

        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqbody).post("/{pp1}");

        HerokuappExpBodyPOJO responsePOJO = response.as(HerokuappExpBodyPOJO.class);


        Assert.assertEquals(expData.getBooking().getFirstname(),responsePOJO.getBooking().getFirstname());
        Assert.assertEquals(expData.getBooking().getLastname(),responsePOJO.getBooking().getLastname());
        Assert.assertEquals(expData.getBooking().getTotalprice(),responsePOJO.getBooking().getTotalprice());
        Assert.assertEquals(expData.getBooking().getBookingdates().getCheckin(),responsePOJO.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expData.getBooking().getBookingdates().getCheckout(),responsePOJO.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(expData.getBooking().getAdditionalneeds(),responsePOJO.getBooking().getAdditionalneeds());


















    }
}
