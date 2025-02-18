package csv.validatedatabeforeprocessing;

import java.io.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/validatedatabeforeprocessing/employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (!columns[3].matches("\\d+")) {
                    System.out.println("Invalid Salary for: " + columns[1]);
                }
                if (!columns[4].matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    System.out.println("Invalid Email for: " + columns[1]);
                }
                if (!columns[5].matches("\\d{10}")) {
                    System.out.println("Invalid Phone Number for: " + columns[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
