package com.csvfilehandlingadvancequestions;

import java.io.*;
import java.util.regex.*;

public class CSVValidator {
    public static void main(String[] args) {
        String filePath = "C:\\Capg\\Week05\\Day01\\Emp.csv";  // Replace with your actual CSV file path
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNumber = 0;
            while ((line = br.readLine()) != null) {
                rowNumber++;
                if (rowNumber == 1) continue; // Skip header row

                String[] values = line.split(",");

                if (values.length < 2) {
                    System.out.println("Row " + rowNumber + " is invalid: Missing columns");
                    continue;
                }

                String email = values[0].trim();
                String phone = values[1].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid) {
                    System.out.println("Row " + rowNumber + " Error: Invalid email - " + email);
                }

                if (!isPhoneValid) {
                    System.out.println("Row " + rowNumber + " Error: Invalid phone number - " + phone);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
