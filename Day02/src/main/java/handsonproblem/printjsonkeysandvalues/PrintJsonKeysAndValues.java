package handsonproblem.printjsonkeysandvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class PrintJsonKeysAndValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/handsonproblem/printjsonkeysandvalues/user.json"));

            for(Map.Entry<String, JsonNode> jk : jsonNode.fields())

            jsonNode.fields().forEachRemaining(entry -> {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}