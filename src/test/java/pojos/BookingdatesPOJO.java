package pojos;


public class BookingdatesPOJO {
    /*
     {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  }
     */

    private String checkin;
    private String checkout;

    public BookingdatesPOJO() {
    }

    public String getCheckin() {
        return checkin;
    }

    @Override
    public String toString() {
        return "BookingdatesPOJO{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

    public BookingdatesPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
