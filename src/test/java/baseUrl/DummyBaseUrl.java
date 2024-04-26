package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class DummyBaseUrl {

    protected RequestSpecification specDummy;

    @BeforeClass
    public void setUp(){

        specDummy = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();
    }
}
