package com.linkedin.eversoncordeiro_da_silva.app.runners;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
/**
 * Class for experimentations solo
 * */
public class Run_Test {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        String baseDir = System.getProperty("user.dir");
        File inputDir = new File(baseDir, "json/input");
        File outputDir = new File(baseDir, "json/output");

        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        File[] jsonFiles = inputDir.listFiles((dir, name) -> name.endsWith(".json"));

        if (jsonFiles == null || jsonFiles.length == 0) {
            System.out.println("Nenhum arquivo JSON encontrado em: " + inputDir.getAbsolutePath());
            return;
        }

        for (File jsonFile : jsonFiles) {
            try {
                JsonNode rootNode = mapper.readTree(jsonFile);
                Properties props = new Properties();
                extractPaths(rootNode, "$", props);

                String outputFileName = jsonFile.getName().replace(".json", ".properties");
                File outputFile = new File(outputDir, outputFileName);
                try (FileWriter writer = new FileWriter(outputFile)) {
                    props.store(writer, "Extraído de " + jsonFile.getName());
                }

                System.out.println("Gerado: " + outputFile.getAbsolutePath());

            } catch (Exception e) {
                System.err.println("Erro ao processar: " + jsonFile.getName());
                e.printStackTrace();
            }
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
