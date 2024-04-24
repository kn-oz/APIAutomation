package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesiOlusturma {


    @Test
    public void jsonObjectCreation(){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","ahmet");
        jsonObject.put("body","merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);

    }

    @Test
    public void jsonObject2(){

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

        JSONObject jsonObject2 = new JSONObject();

        jsonObject2.put("firstname","Jim");
        jsonObject2.put("additional","breakfast");
        jsonObject2.put("bookingdates",bookingdates);
        jsonObject2.put("totalprice","111");
        jsonObject2.put("depositpaid","true");
        jsonObject2.put("lastname","brown");

        System.out.println(jsonObject2);



    }
}
