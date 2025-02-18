package csv.filterrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FilterStudentByMarks {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/filterrecord/student.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // removing the header
            bufferedReader.readLine();
            String line;
            while((line = bufferedReader.readLine()) != null){
                // record of a student
                String[] studentRecord = line.split(",");
                // printing the record if marks are above 80
                if (Integer.parseInt(studentRecord[2].trim()) >= 80) {
                    System.out.println(Arrays.toString(studentRecord));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
