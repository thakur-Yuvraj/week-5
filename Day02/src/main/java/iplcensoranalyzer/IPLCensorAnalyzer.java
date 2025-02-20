package iplcensoranalyzer;

import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.opencsv.*;

import java.io.*;
import java.util.List;

public class IPLCensorAnalyzer {

    // For JSON File
    public static void processJsonFile(String inputFile, String outputFile) {
        try (FileReader reader = new FileReader(inputFile)) {
            JSONArray matches = new JSONArray(new JSONTokener(reader));

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                match.put("team1", censorTeamName(match.getString("team1")));
                match.put("team2", censorTeamName(match.getString("team2")));
                match.put("player_of_match", "REDACTED");
            }

            // Write to output file
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(matches.toString(4));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // For CSV File
    public static void processCsvFile(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> rows = reader.readAll();
            String[] headers = rows.get(0);
            writer.writeNext(headers);

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                row[1] = censorTeamName(row[1]);
                row[2] = censorTeamName(row[2]);
                row[5] = "REDACTED";
                writer.writeNext(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    // Censorship Method for Team Names
    public static String censorTeamName(String team) {
        if (team.contains(" ")) {
            return team.substring(0, team.indexOf(" ")) + " ****";
        }
        return team;
    }

    public static void main(String[] args) {
        // File paths
        String jsonInputFile = "src/main/java/iplcensoranalyzer/jsonfile.json";
        String csvInputFile = "src/main/java/iplcensoranalyzer/csvfile.csv";
        String jsonOutputFile = "src/main/java/iplcensoranalyzer/jsonoutput.json";
        String csvOutputFile = "src/main/java/iplcensoranalyzer/csvoutput.csv";

        // Process JSON and CSV files
        processJsonFile(jsonInputFile, jsonOutputFile);
        processCsvFile(csvInputFile, csvOutputFile);

        System.out.println("Censorship complete. Check output files.");
    }

}
