package practiceproblem.convertjavaobjectintojsonformat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJsonObjectHandler {
    public static void main(String[] args) throws JsonProcessingException {
        // creating an object from car class
        Car car1 = new Car("Punch", "v12");

        try {
            // creating object mapper
            ObjectMapper objectMapper = new ObjectMapper();
            // converting the car1 to JSON object
            String jsonCar1 = objectMapper.writeValueAsString(car1);
            // printing the JSON string
            System.out.println(jsonCar1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
