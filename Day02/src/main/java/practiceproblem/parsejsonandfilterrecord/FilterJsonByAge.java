package practiceproblem.parsejsonandfilterrecord;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/practiceproblem/parsejsonandfilterrecord/user.json"));

            for (JsonNode user : jsonNode) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}