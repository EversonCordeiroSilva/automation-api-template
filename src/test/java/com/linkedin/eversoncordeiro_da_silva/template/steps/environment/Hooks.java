package com.linkedin.eversoncordeiro_da_silva.template.steps.environment;

import com.linkedin.eversoncordeiro_da_silva.template.utils.Context;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.model.StepResult;
import org.assertj.core.api.SoftAssertions;

import java.util.Arrays;
import java.util.List;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.*;

public class Hooks {
    private static final AllureLifecycle LIFECYCLE = Allure.getLifecycle();
    @BeforeAll
    public static void globalSetup() {
        // This method can be used to set up any global state or configurations before all tests run.System.out.println("Setting up the test environment...");
        // Add any necessary setup code here, such as initializing resources or configurations.
    }

    @Before
    public void setUp(Scenario scenario) {
        // This method runs before each scenario.
        Context.start();
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        // This method runs after each step in the scenario.
        Allure.getLifecycle().updateTestCase(ts->{
            List<StepResult> stepResultList = ts.getSteps();
            StepResult stepResult = stepResultList.get(stepResultList.size() - 2);
            if(!softAssert().wasSuccess()) {
                if(ts.getName().equalsIgnoreCase(scenario.getName())) {
                    List<Throwable> errors = softAssert().errorsCollected();
                    stepResult.getStatusDetails().setMessage(errors.getLast().getMessage());
                    stepResult.getStatusDetails().setTrace(Arrays.toString(errors.getLast().getStackTrace()));
                    stepResult.setStatus(Status.FAILED);
                }
            }
        });
    }

    @After
    public void tearDown(Scenario scenario) {
        // This method runs after each scenario.
        // Log all requests and responses for debugging purposes.
        System.out.println(rest().log().all());
        Context.tearDown();
    }

    @AfterAll
    public static void globalTearDown() {
        // This method can be used to clean up any global state or configurations after all tests have run.
    }
}
