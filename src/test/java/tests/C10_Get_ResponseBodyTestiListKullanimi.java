package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void get01(){

        /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin application/json,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .body("data.id", Matchers.hasSize(24))
                .body("data.employee_name",Matchers.hasItem("Ashton Cox"))
                .body("data.employee_age",Matchers.hasItems(61,40,30));



    }
}
