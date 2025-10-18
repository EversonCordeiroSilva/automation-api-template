package com.linkedin.eversoncordeiro_da_silva.template.steps;

import com.linkedin.eversoncordeiro_da_silva.template.logics.Helloworld_En_Logic;
import io.cucumber.java.en.*;

import java.util.HashMap;

public class Helloworld_En_Steps {
    private Helloworld_En_Logic logic;

    public Helloworld_En_Steps() {
        logic = new Helloworld_En_Logic();
    }

    @Given("I captured {string}")
    public void iCaptured(String pokeName) {
        logic.setCapture(pokeName);
    }

    @Then("I expect the {int}")
    public void iExpectTheStatusCode(Integer statusCode) {
        logic.statusExpected(statusCode);
    }

    @Given("I am {string} with identifier {int}")
    public void iAmWithIdentifier(String trainerName, Integer trainerId) {
        logic.setTrainerId(trainerId);
    }

    @And("I am registered in {string} as {string} in the field {string}")
    public void iAmRegisteredInAsInTheField(String payloadName, String workName, String campName) {
        HashMap<String, String> payload = new HashMap<>();
        payload.put(campName, workName);
        logic.setValueInPayload(payloadName, payload);
    }
}
