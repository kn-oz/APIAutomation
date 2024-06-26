package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {


    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
     gonderdigimizde donen Response’un,
     status code’unun 200, ve
      content type’inin
     application/json; charset=utf-8,
     ve
     Server isimli Header’in degerinin
      Cowboy, ve status Line’in HTTP/1.1 200 OK ve response suresinin 5 sn’den kisa oldugunu
      manuel olarak test ediniz.
     */

    @Test
    public void get01(){

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

       // response.prettyPrint();

        System.out.println("status kodu: " + response.getStatusCode());
        System.out.println("content type: " + response.getContentType());
        System.out.println("Server header degeri : " + response.getHeader("Server"));
        System.out.println("Status line : " + response.getStatusLine());
        System.out.println("Respond süresi : " + response.getTime());



    }


}


