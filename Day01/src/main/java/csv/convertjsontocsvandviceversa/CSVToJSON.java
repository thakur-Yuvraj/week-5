package csv.convertjsontocsvandviceversa;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class CSVToJSON {
    public static void main(String[] args) {
        String csvFilePath = "src/main/java/csv/convertjsontocsvandviceversa/students.csv";
        String jsonFilePath = "src/main/java/csv/convertjsontocsvandviceversa/students_output.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = reader.readLine().split(","); // Read header
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                Map<String, String> student = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], columns[i]);
                }
                students.add(student);
            }

            // Write JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}