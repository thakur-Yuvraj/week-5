package csv.detectduplicates;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/detectduplicates/employees.csv";
        Set<String> ids = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                if (!ids.add(id)) { // If ID already exists in the set
                    System.out.println("Duplicate record found: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}