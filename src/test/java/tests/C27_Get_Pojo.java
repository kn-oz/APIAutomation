package tests;

import baseUrl.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpBodyPOJO;

import static io.restassured.RestAssured.given;

public class C27_Get_Pojo extends DummyBaseUrl {
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
    }

     */

    @Test
    public void get01(){


        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        DummyDataPOJO data = new DummyDataPOJO(3,"Ashton Cox",86000,66,"");

        DummyExpBodyPOJO expData = new DummyExpBodyPOJO("success",data,"Successfully! Record has been fetched.");

        Response response = given().spec(specDummy).contentType(ContentType.JSON).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        DummyExpBodyPOJO responsePOJO = response.as(DummyExpBodyPOJO.class);

        Assert.assertEquals(expData.getStatus(),responsePOJO.getStatus());
        Assert.assertEquals(expData.getMessage(),responsePOJO.getMessage());

        Assert.assertEquals(expData.getData().getEmployee_name(),responsePOJO.getData().getEmployee_name());
        Assert.assertEquals(expData.getData().getEmployee_salary(),responsePOJO.getData().getEmployee_salary());
        Assert.assertEquals(expData.getData().getEmployee_age(),responsePOJO.getData().getEmployee_age());
        Assert.assertEquals(expData.getData().getId(),responsePOJO.getData().getId());
        Assert.assertEquals(expData.getData().getProfile_image(),responsePOJO.getData().getProfile_image());








    }
}
