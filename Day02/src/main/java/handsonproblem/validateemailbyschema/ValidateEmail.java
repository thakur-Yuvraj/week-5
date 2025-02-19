package handsonproblem.validateemailbyschema;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateEmail {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/handsonproblem/validateemailbyschema/schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonData = objectMapper.readTree(new File("src/main/java/handsonproblem/validateemailbyschema/user.json"));

            // Validate Email
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