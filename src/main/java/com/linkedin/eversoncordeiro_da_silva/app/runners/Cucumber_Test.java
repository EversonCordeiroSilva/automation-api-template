package com.linkedin.eversoncordeiro_da_silva.app.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * Main runner class for run Automation.
 * */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        tags = "@consulta_pokemon",
        glue = "com.linkedin.eversoncordeiro_da_silva.steps",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class Cucumber_Test {
}
