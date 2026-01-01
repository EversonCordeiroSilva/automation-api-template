package com.linkedin.eversoncordeiro_da_silva.template.utils;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;

public class Context {
    private static final ThreadLocal<RequestSpecification> REST = new ThreadLocal<>();
    private static final ThreadLocal<SoftAssertions> SOFT_ASSERT = new ThreadLocal<>();

/// initializes the tools of assertions and rest assured
    public static void start(){
        REST.set(RestAssured.requestSpecification);
        SOFT_ASSERT.set(new SoftAssertions());
    }

/// shutdown the tools of assertions and rest assured
    public static void tearDown(){
        if (REST.get() != null) {
            REST.remove();
        }
        assertAll();
    }

    public static RequestSpecification rest(){
        return REST.get();
    }
    /// Tools of assertions
    public static SoftAssertions softAssert(){
        return SOFT_ASSERT.get();
    }
    /// Tools of assertions
    public static void assertAll(){
        if (SOFT_ASSERT.get() != null) {
            SOFT_ASSERT.get().assertAll();
            SOFT_ASSERT.remove();
        }
    }
    /// Initializes a new request with default settings
    public static void newRequest(){
        RestAssured.reset();
        REST.set(RestAssured.given());
        rest().contentType(ContentType.JSON);
        rest().accept(ContentType.JSON);
        rest().relaxedHTTPSValidation();
        rest().filter(new AllureRestAssured());
    }

}
