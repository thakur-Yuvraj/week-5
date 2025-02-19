package practiceproblem.createjsonobjectforstudent;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSONHandler {

    public static void main(String[] args) {
        // creating JSON object for a student
        JSONObject student = new JSONObject();

        student.put("Name", "nameless");
        student.put("Age", 23);

        // JSON array to store subjects
        JSONArray subjects = new JSONArray();
        subjects.put("subject1");
        subjects.put("subject2");
        subjects.put("subject3");

        student.put("Subjects", subjects);

        System.out.println(student.toString());
    }
}
