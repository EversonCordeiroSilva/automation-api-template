package com.linkedin.eversoncordeiro_da_silva.template.logics.requests.login;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public enum Payload {
    EMAIL,USER,PASS;
    private String getMarkdown(){
        return "<"+this.name().toUpperCase()+">";
    }

    private static Path loginPath() throws URISyntaxException {
        return Paths.get(Payload.class.getClassLoader().getResource("payloads/login.json").toURI());
    }

    public static String getPayload(String email, String user, String pass){
        StringBuilder payload = new StringBuilder();
        try {
            List<String> payloadLogin = Files.readAllLines(loginPath());
            for(String line : payloadLogin){
                line = line.replace(EMAIL.getMarkdown(), email);
                line = line.replace(USER.getMarkdown(), user);
                line = line.replace(PASS.getMarkdown(), pass);
                payload.append(line);
            }
            return payload.toString();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
