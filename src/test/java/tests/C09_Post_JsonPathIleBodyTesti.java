package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {

     /*
            https://restful-booker.herokuapp.com/booking
            url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

    @Test
    public void post02(){

    String url = "https://restful-booker.herokuapp.com/booking";

    JSONObject reqBody = new JSONObject();

    reqBody.put("firstname" , "Ali").put("lastname" , "Bak").put(
                "totalprice" , 500).put("depositpaid", false);

    JSONObject bookingdates = new JSONObject();

    bookingdates.put("checkin" , "2021-06-01").put(
                "checkout", "2021-06-10");

    reqBody.put("bookingdates",bookingdates).put("additionalneeds" , "wi-fi");


        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);


        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ali"))
                .body("booking.lastname",equalTo("Bak"))
                .body("booking.bookingdates.checkin",equalTo("2021-06-01"))
                .body("booking.bookingdates.checkout",equalTo("2021-06-10"));



    }
}
