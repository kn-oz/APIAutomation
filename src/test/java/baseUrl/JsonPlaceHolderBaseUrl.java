package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeClass;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification specJsonPlace;

    @BeforeClass
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();


}
}
