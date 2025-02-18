package csv.readlargecsvfile;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/csv/readlargecsvfile/large_file.csv";
        int chunkSize = 100;
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                recordCount++;
                // Process the line (e.g., print or store in a list)
//                System.out.println(line);

                // Process in chunks
                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records so far.");
                }
            }
            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
