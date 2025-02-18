package csv.encryptanddecryptcsvdata;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;
public class EncryptCSV {
    private static SecretKey secretKey;

    public static void main(String[] args) {

        String filePath = "src/main/java/csv/encryptanddecryptcsvdata/employees.csv";
        String encryptedFilePath = "src/main/java/csv/encryptanddecryptcsvdata/employees_encrypted.csv";
        String keyFilePath = "src/main/java/csv/encryptanddecryptcsvdata/secret.key"; // File to save the secret key

        try {
            // Generate a secret key
            secretKey = KeyGenerator.getInstance("AES").generateKey();

            // Save the secret key to a file
            try (ObjectOutputStream keyOutputStream = new ObjectOutputStream(new FileOutputStream(keyFilePath))) {
                keyOutputStream.writeObject(secretKey);
            }

            // Encrypt the CSV file
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");
                    columns[3] = encrypt(columns[3]); // Encrypt Salary
                    columns[4] = encrypt(columns[4]); // Encrypt Email
                    writer.write(String.join(",", columns) + "\n");
                }
                System.out.println("CSV file encrypted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}