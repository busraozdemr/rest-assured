package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import util.JsonUtil;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ResponseAssertion {
    final BaseStep baseStep = BaseStep.getInstance();

    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        baseStep.response.then().assertThat().statusCode(statusCode);
        baseStep.response.prettyPrint();
    }

    @And("integer value of {string} field is {int}")
    public void integerValueOfFieldIs(String fieldName, int fieldValue) {
        baseStep.response.then().assertThat().body(fieldName,is(fieldValue));
    }

    @And("string value of {string} field is {string}")
    public void stringValueOfFieldIs(String fieldName, String fieldValue) {
        baseStep.response.then().assertThat().body(fieldName,is(fieldValue));
    }

    @And("user should see {string} list size should be {int}")
    public void userShouldSeeListSizeShouldBe(String listName, int listSize) {
        baseStep.response.then().assertThat().body(listName+".size()",is(listSize));
    }

    @And("string value of {string} field contains {string}")
    public void stringValueOfFieldContains(String fieldName, String fieldValue) {
        baseStep.response.then().assertThat().body(fieldName,containsString(fieldValue));
    }

    @And("response schema should be {string}")
    public void responseSchemaShouldBe(String schemaFileName) {
        baseStep.response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(JsonUtil.getJsonSchemaPath(schemaFileName)));
    }
}
