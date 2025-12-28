package com.linkedin.eversoncordeiro_da_silva.template.logics;

import com.google.gson.JsonObject;
import com.linkedin.eversoncordeiro_da_silva.template.logics.requests.login.LoginRequest;

import static com.linkedin.eversoncordeiro_da_silva.template.utils.Context.*;

public class Login_Logic {
    private LoginRequest loginRequest;

    public Login_Logic(){
        loginRequest = new LoginRequest();
    }

    public void sendValidCredentials(){
        loginRequest.request();
    }

    public void sendCredentials(String mail, String pass){
        loginRequest.request(mail, pass);
    }

    public void statusCodeIsValid(int statusExpected){
        softAssert().assertThat(loginRequest.statusCodeIsValid(statusExpected))
                .as("Expected status code to be <%s>, but it was not", statusExpected).isTrue();
    }

    public void validResponseLogin(){
        JsonObject jsonObject = loginRequest.getJsonObject();
        boolean accessToken = jsonObject.has("access_token") && !jsonObject.get("access_token").isJsonNull();
        boolean refreshToken = jsonObject.has("refresh_token") && !jsonObject.get("refresh_token").isJsonNull();

        softAssert().assertThat(accessToken)
                .as("Expected a accessToken, but it was not")
                .isTrue();

        softAssert().assertThat(refreshToken)
                .as("Expected a refreshToken, but it was not")
                .isTrue();

    }

}
