package com.linkedin.eversoncordeiro_da_silva.steps.app;

import com.linkedin.eversoncordeiro_da_silva.utils.Context;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import static com.linkedin.eversoncordeiro_da_silva.utils.Context.rest;

public class Hooks {
    @BeforeAll
    public static void setup() {
        // This method can be used to set up any global state or configurations before all tests run.
        System.out.println("Setting up the test environment...");
        // Add any necessary setup code here, such as initializing resources or configurations.
        Context.start();
    }
    @AfterAll
    public static void tearDown() {
        // This method can be used to clean up any global state or configurations after all tests have run.
        System.out.println("Tearing down the test environment...");
        System.out.println(rest().log().all()); // Log all requests and responses for debugging purposes.
        // Add any necessary cleanup code here, such as releasing resources or resetting configurations.
        Context.tearDown();
    }
}
