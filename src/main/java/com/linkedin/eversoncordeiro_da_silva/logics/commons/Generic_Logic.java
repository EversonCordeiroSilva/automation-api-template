package com.linkedin.eversoncordeiro_da_silva.logics.commons;

import com.linkedin.eversoncordeiro_da_silva.app.runners.BaseUri;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.linkedin.eversoncordeiro_da_silva.utils.Context.*;
import static com.linkedin.eversoncordeiro_da_silva.utils.Constants.*;
import static com.linkedin.eversoncordeiro_da_silva.utils.Utils.extractJsonFromRest;

public class Generic_Logic {

    public static final Generic_Logic getInstance(){
        return new Generic_Logic();
    }

    public void sendRequest(String url, String method, String endPointName) {
        // Logic to send a request
        System.out.println("Sending " + method + " request to " + url + " with endpoint: " + endPointName);
        BaseUri uri = BaseUri.valueOf(url);
        if(uri.equals(BaseUri.REQRES_API))
            rest().header("x-api-key","reqres-free-v1");
        rest().baseUri(uri.toString());
        rest().basePath(endPointName);
        if(PAYLOAD != null && !PAYLOAD.isEmpty()) {
            for (String value : PAYLOAD.values()) {
                System.out.println("Payload: " + value);
                rest().body(value);
            }
            PAYLOAD = new HashMap<>(); // Clear payload after use
        }
        switch (method){
            case "GET":
                // Logic for GET request
                System.out.println("Executing GET request");
                RESPONSE = rest().get();
                break;
            case "POST":
                // Logic for POST request
                System.out.println("Executing POST request");
                RESPONSE = rest().post();
                break;
            case "PUT":
                // Logic for PUT request
                System.out.println("Executing PUT request");
                RESPONSE = rest().put();
                break;
            case "DELETE":
                // Logic for DELETE request
                System.out.println("Executing DELETE request");
                RESPONSE = rest().delete();
                break;
            default:
                System.out.println("Unsupported HTTP method: " + method);
        }
        extractJsonFromRest(RESPONSE,"response");
    }

    public void statusExpected(Integer statusCode) {
        System.out.println("Validating response status code: " + statusCode);
        System.out.println("Response status code: " + RESPONSE.getStatusCode());
        softAssert().assertThat(RESPONSE.getStatusCode()).isEqualTo(statusCode);
    }

    public void loadPayload(String payloadName) {
        // Logic to set payload
        System.out.println("Setting payload: " + payloadName);
        newRequest();
        PAYLOAD = new HashMap<>();
        try {
            StringBuilder body = new StringBuilder();
            for(String line : Files.readAllLines(getPayloadFile(payloadName))) {
                System.out.println("Payload line: " + line);
                body.append(line).append("\n");
            }
            PAYLOAD.put(payloadName, body.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValueInPayload(String payloadName, Map<String,String> value) {
        // Logic to set a key-value pair in the payload
        System.out.println("Setting payload: " + payloadName);
        String payloadValue = PAYLOAD.get(payloadName);
        for(Map.Entry<String, String> entry : value.entrySet()) {
            payloadValue = payloadValue.replace("{"+entry.getKey()+"}", entry.getValue());
        }
        PAYLOAD.put(payloadName,payloadValue);
    }

    public Path getPayloadFile(String payLoadName) {
        // Logic to get payload file name
        System.out.println("Getting payload file name: " + payLoadName);
        String baseDir = System.getProperty("user.dir");
        String payloadPath = baseDir + "/src/main/resources/payloads/request/" + payLoadName + ".json";
        return Paths.get(payloadPath);
    }

}
