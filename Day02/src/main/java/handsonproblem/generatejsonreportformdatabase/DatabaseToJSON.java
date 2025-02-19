package handsonproblem.generatejsonreportformdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseToJSON {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String jsonFilePath = "employees_report.json";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Fetch data from the database
            String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a list to hold employee objects
            List<Employee> employees = new ArrayList<>();

            // Collect data from the result set and store it in a list
            while (resultSet.next()) {
                String employeeID = resultSet.getString("EmployeeID");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                String salary = resultSet.getString("Salary");

                Employee employee = new Employee(employeeID, name, department, salary);
                employees.add(employee);
            }

            // Write the list of employees to a JSON file
            objectMapper.writeValue(new File(jsonFilePath), employees);

            System.out.println("JSON report generated successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
