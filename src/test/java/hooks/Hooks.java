package hooks;

import config.SutConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import steps.BaseStep;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    @Before
    public void beforeEachScenario() {

        RestAssured.baseURI = SutConfiguration.getProps().getProperty("sut.url");
    }

    @After
    public void afterEachScenario(Scenario scenario) {
        BaseStep.getInstance().response = null;
        BaseStep.getInstance().requestSpecification = RestAssured.given();
    }

}
