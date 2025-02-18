package com.csvfilehandlingintermediatequestions;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    public static void main(String[] args) {
        // Define the file paths
        String inputFile = "C:\\Capg\\Week05\\Day01\\Employee.csv";
        String outputFile = "C:\\Capg\\Week05\\Day01\\EncryptedEmployee.csv";

        // Encryption Key (Use a secure way to store keys in real-world scenarios)
        String key = "1234567812345678"; // 16 characters = 128 bits for AES

        try {
            // Encrypt the data and write it to the CSV file
            encryptAndWriteCSV(inputFile, outputFile, key);

            // Read the encrypted file and decrypt the data
            String decryptedFile = "C:\\Capg\\Week05\\Day01\\DecryptedEmployee.csv";
            decryptAndReadCSV(outputFile, decryptedFile, key);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to encrypt and write CSV data to a new file
    public static void encryptAndWriteCSV(String inputFile, String outputFile, String key) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line by commas
            String[] data = line.split(",");

            // Encrypt sensitive fields (Salary and Email)
            data[2] = encrypt(data[2], key);  // Encrypt Salary
            data[3] = encrypt(data[3], key);  // Encrypt Email

            // Write the encrypted data back to the file
            writer.write(String.join(",", data));
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    // Method to decrypt and read CSV data
    public static void decryptAndReadCSV(String inputFile, String outputFile, String key) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line by commas
            String[] data = line.split(",");

            // Decrypt sensitive fields (Salary and Email)
            data[2] = decrypt(data[2], key);  // Decrypt Salary
            data[3] = decrypt(data[3], key);  // Decrypt Email

            // Write the decrypted data back to the new file
            writer.write(String.join(",", data));
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    // Method to encrypt data using AES
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to decrypt data using AES
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
