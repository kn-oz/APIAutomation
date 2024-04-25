package testData;

import org.json.JSONObject;




public class TestDataHerokuapp {

    public JSONObject bookingdatesOlusturJson(){

        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2021-06-01").put(
                "checkout","2021-06-10");

        return bookingDates;

    }

    public JSONObject bookingOlusturJson(){

        JSONObject booking = new JSONObject();

        booking.put("firstname","Ali")
                .put("lastname","Bak")
                .put("totalprice",500)
                .put("depositpaid",false)
                .put("bookingdates",bookingdatesOlusturJson())
                .put("additionalneeds","wi-fi");

        return booking;
    }

    public JSONObject expectedBodyOlusturJson(){

        JSONObject expData = new JSONObject();

        expData.put("bookindid",24).put(
                "booking",bookingOlusturJson());

        return expData;


    }

    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8";
}
