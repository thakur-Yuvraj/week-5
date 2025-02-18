package csv.readandcountrecord;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountRowsInCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/readandcountrecord/employees.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // skipping the header
            bufferedReader.readLine();

            // counter to count the lines after header
            int rowCount = 0;
            while (bufferedReader.readLine() != null) {
                rowCount++;
            }

            // printing the count
            System.out.println("Number of records are : "+ rowCount);
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
