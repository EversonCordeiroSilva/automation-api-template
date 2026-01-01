package com.linkedin.eversoncordeiro_da_silva.template.runners;


import com.linkedin.eversoncordeiro_da_silva.template.utils.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    glue = "com.linkedin.eversoncordeiro_da_silva.template.steps",
    features = "classpath:features",
    plugin = {
            "pretty",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },
    monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {}
