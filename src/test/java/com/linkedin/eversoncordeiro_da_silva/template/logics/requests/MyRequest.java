package com.linkedin.eversoncordeiro_da_silva.template.logics.requests;


public interface MyRequest {
    String BASE_URL = "https://www.advantageonlineshopping.com";

    void request();

    boolean statusCodeIsValid(int statusCodeExpected);
}
