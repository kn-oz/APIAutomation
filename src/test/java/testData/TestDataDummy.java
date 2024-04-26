package testData;

import java.util.HashMap;
import java.util.Objects;

public class TestDataDummy {

    public int basariliStatuscode = 200;

    public String contentType = "application/json";



    public HashMap dataBodyOlusturmaMap(){


        HashMap<String, Object> data = new HashMap<>();

        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");


        return data;

    }

    public HashMap expBodyOlusturmaMap() {


        HashMap<String, Object> expBody = new HashMap<>();

        expBody.put("status","success");
        expBody.put("data",dataBodyOlusturmaMap());
        expBody.put("message","Successfully! Record has been fetched.");


        return expBody;

    }
}
