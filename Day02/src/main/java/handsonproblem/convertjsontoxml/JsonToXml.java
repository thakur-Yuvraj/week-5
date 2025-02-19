package handsonproblem.convertjsontoxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            File jsonFile = new File("src/main/java/handsonproblem/convertjsontoxml/user.json");
            File xmlFile = new File("src/main/java/handsonproblem/convertjsontoxml/user.xml");

            // Step 1: Read JSON file into a Java object (Map or POJO)
            ObjectMapper jsonMapper = new ObjectMapper();
            Map<String, Object> jsonData = jsonMapper.readValue(jsonFile, Map.class);

            // Step 2: Write the Java object to an XML file
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(xmlFile, jsonData);

            System.out.println("JSON converted to XML successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}