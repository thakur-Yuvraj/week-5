package practiceproblem.readjsonfileandextractonlyspecificfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONExtractFields {
    public static void main(String[] args) {
    try {
        // creating an object of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String filePath = "src/main/java/practiceproblem/readjsonfileandextractonlyspecificfields/student.json";

        // json node object to read the file
        JsonNode jsonNode = objectMapper.readTree(new File(filePath));

        String name = jsonNode.get("Name").asText();
        String email = jsonNode.get("Email").asText();

        System.out.println("Name is : " + name + " Email is : " + email);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
}
