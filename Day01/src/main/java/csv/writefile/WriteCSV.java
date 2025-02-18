package csv.writefile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/writefile/employees.csv";

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write("ID,Name,Department,Salary\n");
            bufferedWriter.write("101,John Doe,Engineering,60000\n");
            bufferedWriter.write("102,Jane Smith,HR,50000\n");
            bufferedWriter.write("103,Michael Brown,Marketing,55000\n");
            bufferedWriter.write("104,Alice Williams,Finance,62000\n");
            bufferedWriter.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
