package com.linkedin.eversoncordeiro_da_silva.template.steps;

import com.linkedin.eversoncordeiro_da_silva.template.logics.Login_Logic;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class Login_Steps {
    private Login_Logic logic;

    public Login_Steps() {
        logic = new Login_Logic();
    }


    @Given("the Fake Store API is available")
    public void theFakeStoreAPIIsAvailable() {
        logic.sendValidCredentials();
        logic.statusCodeIsValid(201);
    }

    @When("I authenticate with valid credentials")
    public void iAuthenticateWithValidCredentials() {
        logic.sendValidCredentials();
    }

    @Then("the API should return status code {int}")
    public void theAPIShouldReturnStatusCode(int statusExpected) {
        logic.statusCodeIsValid(statusExpected);
    }

    @And("an authentication token should be returned")
    public void anAuthenticationTokenShouldBeReturned() {
        logic.validResponseLogin();
    }

    @When("I authenticate with email {string} and password {string}")
    public void iAuthenticateWithEmailAndPassword(String mail, String pass) {
        logic.sendCredentials(mail,pass);
    }
}
