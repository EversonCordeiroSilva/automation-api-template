package com.linkedin.eversoncordeiro_da_silva.template.steps.commons;

import com.linkedin.eversoncordeiro_da_silva.template.logics.commons.Generic_Logic;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Generic_Steps {
    Generic_Logic logic;

    public Generic_Steps() {
        logic = Generic_Logic.getInstance();
    }

    /**
     * Generic step to send request to the endpoint.
     */
    @When("I send to the {string} on the endpoint {string} {string}")
    public void iSendToTheEndpoint(String apiName, String methodName, String endPointName) {
        logic.sendRequest(apiName, methodName, endPointName);
    }

    /**
     * Generic step to set payload for the request.
     */
    @And("I have the {string}")
    public void iHaveThe(String payLoadName) {
        logic.loadPayload(payLoadName);
    }

    /**
     * Generic step to validate value inside response JSON.
     */
    @And("I validate if the Pokémon has {} {string} and if it is found in {string}")
    public void iValidateIfPokemonHasValueAndItIsFoundIn(String campType, String value, String jsonPath) {
        logic.validateResponse(value, jsonPath);
    }
}
