package csv.convertdatatoobject;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class ParseStudentCSV {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/main/java/csv/convertdatatoobject/student.csv");
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Student> students = csvToBean.parse();
            for (Student student : students) {
                System.out.println(student.getName() + " scored " + student.getMarks());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}