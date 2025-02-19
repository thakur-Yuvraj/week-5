package practiceproblem.validatejsonstruction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateJSONStructure {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/practiceproblem/validatejsonstruction/schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonData = objectMapper.readTree(new File("src/main/java/practiceproblem/validatejsonstruction/user.json"));

            // Validate JSON
            if (schema.validate(jsonData).isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}