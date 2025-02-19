package handsonproblem.mergetwofiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the first JSON file
            File file1 = new File("src/main/java/handsonproblem/mergetwofiles/file1.json");
            JsonNode jsonNode1 = objectMapper.readTree(file1);

            // Read the second JSON file
            File file2 = new File("src/main/java/handsonproblem/mergetwofiles/file2.json");
            JsonNode jsonNode2 = objectMapper.readTree(file2);

            // Merge the two JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1); // Add all fields from the first JSON
            mergedJson.setAll((ObjectNode) jsonNode2); // Add all fields from the second JSON

            // Write the merged JSON to a new file
            File mergedFile = new File("src/main/java/handsonproblem/mergetwofiles/merged.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(mergedFile, mergedJson);

            System.out.println("JSON files merged successfully!");
            System.out.println(mergedJson.toPrettyString()); // Print merged JSON to console
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}