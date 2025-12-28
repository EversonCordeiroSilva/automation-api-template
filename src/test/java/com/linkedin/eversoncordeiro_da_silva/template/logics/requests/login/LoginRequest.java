package com.linkedin.eversoncordeiro_da_silva.template.logics.requests.login;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.linkedin.eversoncordeiro_da_silva.template.logics.requests.MyRequest;
import io.restassured.response.Response;
import lombok.Getter;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.newRequest;
import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.rest;

public class LoginRequest implements MyRequest {
    @Getter
    private JsonObject jsonObject;
    @Getter
    private Response localResponse;
    private String endpoint = "/api/v1/auth/login";

    @Override
    public void request() {
        request("john@mail.com","changeme");
    }

    public void request(String email, String pass) {
        newRequest();
        Gson gson = new Gson();
        rest().baseUri(BASE_URL);
        rest().basePath(endpoint);
        rest().body(Payload.getPayload(email,pass));
        localResponse = rest().post();
        jsonObject = gson.fromJson(localResponse.asString(), JsonObject.class);
    }

    @Override
    public boolean statusCodeIsValid(int statusCodeExpected) {
        return localResponse.getStatusCode() == statusCodeExpected;
    }
}
