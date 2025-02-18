package csv.sortrecordbyacolumn;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/sortrecordbyacolumn/employees.csv";
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            records.add(br.readLine().split(",")); // Add header
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by Salary (column index 3)
        records.subList(1, records.size()).sort((a, b) ->
                Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        // Print top 5
        for (int i = 0; i < Math.min(6, records.size()); i++) {
            System.out.println(String.join(", ", records.get(i)));
        }
    }
}