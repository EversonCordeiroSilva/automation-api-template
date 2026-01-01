package com.linkedin.eversoncordeiro_da_silva.template.logics;

import com.google.gson.JsonObject;
import com.linkedin.eversoncordeiro_da_silva.template.logics.requests.login.LoginRequest;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.*;

public class Login_Logic {
    private final LoginRequest loginRequest = new LoginRequest();

    public void sendValidCredentials(){
        loginRequest.request();
    }

    public void sendCredentials(String mail, String user, String pass){
        loginRequest.request(mail, user, pass);
    }

    public void statusCodeIsValid(int statusExpected){
        softAssert().assertThat(loginRequest.statusCodeIsValid(statusExpected)).as("Expected status code to be <%s>, but it was not", statusExpected).isTrue();
    }

    public void validResponseLogin(){
        JsonObject jsonObject = loginRequest.getJsonObject();
        boolean mainBody = jsonObject.has("statusMessage") && !jsonObject.get("statusMessage").isJsonNull();
        softAssert().assertThat(mainBody)
                .as("Expected a mainBody, but it was not")
                .isTrue();
        if(mainBody) {
            JsonObject statusMessage = jsonObject.getAsJsonObject("statusMessage");
            boolean accessToken = statusMessage.has("token") && !statusMessage.get("token").isJsonNull();
            boolean sessionId = statusMessage.has("sessionId") && !statusMessage.get("sessionId").isJsonNull();

            softAssert().assertThat(accessToken)
                    .as("Expected a accessToken, but it was not")
                    .isTrue();

            softAssert().assertThat(sessionId)
                    .as("Expected a sessionId, but it was not")
                    .isTrue();
        }
    }

}
