//Basic Problems
//1️⃣ Read a CSV File and Print Data
//Read a CSV file containing student details (ID, Name, Age, Marks).
//Print each record in a structured format.


package csv.readcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/readcsvfile/employees.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID is : "+ data[0] + " name is : "+ data[1] + " Age is : "+ data[2] + " Total Marks are :"+ data[3]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
