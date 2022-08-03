package steps;

import io.cucumber.java.en.When;

public class HttpRequest {

    final BaseStep baseStep = BaseStep.getInstance();

    @When("get path {string}")
    public void get_path(String path) {

        baseStep.response = baseStep.requestSpecification.get(path);
    }

    @When("post path {string}")
    public void postPath(String path) {

        baseStep.response = baseStep.requestSpecification.post(path);
    }
}
