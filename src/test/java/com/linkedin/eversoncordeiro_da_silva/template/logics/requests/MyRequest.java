package com.linkedin.eversoncordeiro_da_silva.template.logics.requests;


public interface MyRequest {
    String BASE_URL = "https://api.escuelajs.co";

    void request();

    boolean statusCodeIsValid(int statusCodeExpected);
}
