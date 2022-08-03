package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import util.JsonUtil;

import java.io.IOException;

public class RequestCreation {
    final BaseStep baseStep=BaseStep.getInstance();

    @Given("header {string} is {string}")
    public void header_is(String header, String value) {
        baseStep.requestSpecification.relaxedHTTPSValidation();
        baseStep.requestSpecification.header(header,value);
    }

    @And("request body is {string}")
    public void requestBodyIs(String filePath) throws IOException {
        baseStep.requestSpecification
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(JsonUtil.getJsonRequestFromFile(filePath));
    }
}
