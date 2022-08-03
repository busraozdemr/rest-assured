package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseStep {
    public Response response;

    public RequestSpecification requestSpecification = RestAssured.given();

    private static BaseStep instance = null;

    private synchronized static void createInstance() {
        instance = new BaseStep();
    }

    public static BaseStep getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
}
