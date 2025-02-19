package practiceproblem.mergejsonobject;

import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {
        // creating two JSON files
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        jsonObject1.put("Name", "Nameless");
        jsonObject1.put("Age", 11);

        jsonObject2.put("Email", "hello@gmail.com");
        jsonObject2.put("City", "Bhopal");

        // merging two obj into one obj
        for (String key : jsonObject2.keySet()) {
            jsonObject1.put(key, jsonObject2.get(key));
        }

        // printing the merged object
        System.out.println(jsonObject1.toString());
    }
}
