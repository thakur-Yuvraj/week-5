package csv.modifyafile;

import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/readandcountrecord/employees.csv";
        String dest = "src/main/java/csv/readandcountrecord/updated_employees.csv";
        List<String[]> updatedRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            updatedRecords.add(br.readLine().split(",")); // Add header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equals("IT")) {
                    double salary = Double.parseDouble(columns[3]);
                    salary *= 1.10; // Increase salary by 10%
                    columns[3] = String.valueOf(salary);
                }
                updatedRecords.add(columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated records to a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
            for (String[] record : updatedRecords) {
                writer.write(String.join(",", record) + "\n");
            }
            System.out.println("CSV file updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
