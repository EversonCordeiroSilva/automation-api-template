package com.linkedin.eversoncordeiro_da_silva.template.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Utils {
    private static final String baseDir = System.getProperty("user.dir");

    public static Properties getResponseFromProperties(String fileName) {
        Properties prop = new Properties();
        try {
            prop.load(Files.newBufferedReader(Paths.get(baseDir,"src/test/resources/payloads/response",fileName+".properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static void extractJsonFromRest(Response response, String jsonFile){
        jsonFile = jsonFile+".properties";
        final ObjectMapper mapper = new ObjectMapper();
        File outputDir = new File(baseDir, "src/test/resources/payloads/response");

        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        try {
            JsonNode rootNode = mapper.readTree(response.getBody().asString());
            Properties props = new Properties();
            extractPaths(rootNode, "$", props);

            File outputFile = new File(outputDir, jsonFile);
            try (FileWriter writer = new FileWriter(outputFile)) {
                props.store(writer, "Response Extraido");
            }
            System.out.println("Gerado: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Erro ao processar: " + jsonFile);
            e.printStackTrace();
        }
    }

    private static void extractPaths(JsonNode node, String currentPath, Properties props) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                extractPaths(field.getValue(), currentPath + "." + field.getKey(), props);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                extractPaths(node.get(i), currentPath + "[" + i + "]", props);
            }
        } else {
            props.setProperty(currentPath, node.isNull() ? "null" : node.asText());
        }
    }
}
