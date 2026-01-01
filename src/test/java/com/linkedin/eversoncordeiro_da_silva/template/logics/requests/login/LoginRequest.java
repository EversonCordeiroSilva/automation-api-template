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

    @Override
    public void request() {
        request("qa.automation.aos01@gmail.com","qa_auto_user01", "Test@1234");
    }

    public void request(String email, String user, String pass) {
        String endpoint = "/accountservice/accountrest/api/v1/login";
        newRequest();
        Gson gson = new Gson();
        rest().baseUri(BASE_URL);
        rest().basePath(endpoint);
        rest().body(Payload.getPayload(email,user,pass));
        localResponse = rest().post();
        jsonObject = gson.fromJson(localResponse.asString(), JsonObject.class);
    }

    @Override
    public boolean statusCodeIsValid(int statusCodeExpected) {
        return localResponse.getStatusCode() == statusCodeExpected;
    }
}
