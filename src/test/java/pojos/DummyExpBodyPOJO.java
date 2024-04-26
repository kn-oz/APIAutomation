package pojos;

public class DummyExpBodyPOJO {

    /*
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

    private String status;
    private DummyDataPOJO data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPOJO getData() {
        return data;
    }

    public void setData(DummyDataPOJO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DummyExpBodyPOJO(String status, DummyDataPOJO data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyExpBodyPOJO() {
    }

    @Override
    public String toString() {
        return "DummyExpBodyPOJO{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
