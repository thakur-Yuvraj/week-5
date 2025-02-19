package practiceproblem.converlistofobjecttojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            // creating object mapper
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = Arrays.asList(
                    new Student("Alice", 20),
                    new Student("Bob", 22)
            );
            // converting a list of object to JSON array
            String jsonArray = objectMapper.writeValueAsString(students);

            // printing the JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}