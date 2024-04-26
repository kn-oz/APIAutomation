package pojos;



public class HerokuappExpBodyPOJO {

    /*
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
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
     */

    private  int bookingid;
    private  BookingPOJO booking;

    public HerokuappExpBodyPOJO() {
    }

    @Override
    public String toString() {
        return "HerokuappExpBodyPOJO{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }

    public HerokuappExpBodyPOJO(int bookingid, BookingPOJO booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPOJO getBooking() {
        return booking;
    }

    public void setBooking(BookingPOJO booking) {
        this.booking = booking;
    }
}
