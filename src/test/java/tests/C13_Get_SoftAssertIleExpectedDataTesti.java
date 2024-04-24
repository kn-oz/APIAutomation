package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."

     */

    @Test
    public void get01(){

    String url = "http://dummy.restapiexample.com/api/v1/employee/3";

    Response response = given().when().get(url);

    JsonPath responseJP = response.jsonPath();


    JSONObject data = new JSONObject();

    data.put("id",3).put(
                "employee_name","Ashton Cox").put(
                "employee_salary",86000).put(
                "employee_age",66).put(
                "profile_image","");

    JSONObject expData = new JSONObject();

    expData.put( "status","success").put("data",data);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expData.getJSONObject("data").get("id"),responseJP.get("data.id"));

        softAssert.assertEquals(responseJP.get("status"),expData.get("status"));
        softAssert.assertEquals(responseJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJP.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJP.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));




        softAssert.assertAll();



}
}