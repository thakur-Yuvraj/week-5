package csv.searchrecord;

import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/searchrecord/employees.csv";
        String searchName = "John Doe";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] employeeRecord = line.split(",");
                if (employeeRecord[1].equals(searchName)) {
                    System.out.println("Department: " + employeeRecord[2] + ", Salary: " + employeeRecord[3]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
