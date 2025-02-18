package csv.mergetwocsvfiles;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        Map<String, String[]> mergedData = new HashMap<>();
        // file paths for students
        String filePath1 = "src/main/java/csv/mergetwocsvfiles/students1.csv";
        String filePath2 = "src/main/java/csv/mergetwocsvfiles/students2.csv";

        // destination file to store the merge of two files
        String destination = "src/main/java/csv/mergetwocsvfiles/merged_students.csv";
        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader br2 = new BufferedReader(new FileReader(filePath2))) {
            // Read students1.csv
            br1.readLine(); // Skip header
            String line;
            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                mergedData.put(columns[0], new String[]{columns[1], columns[2], "", ""});
            }

            // Read students2.csv
            br2.readLine(); // Skip header
            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                if (mergedData.containsKey(columns[0])) {
                    String[] data = mergedData.get(columns[0]);
                    data[2] = columns[1]; // Marks
                    data[3] = columns[2]; // Grade
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write merged data to a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (Map.Entry<String, String[]> entry : mergedData.entrySet()) {
                writer.write(entry.getKey() + "," + String.join(",", entry.getValue()) + "\n");
            }
            System.out.println("CSV files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}