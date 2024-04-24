package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class HerokuAppBaseUrl {

    protected RequestSpecification specHerokuApp;

    @BeforeClass
    public void setUp(){
        specHerokuApp = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}
