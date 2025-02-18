package com.csvfilehandlingintermediatequestions;
//import
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        // File path
        String filePath = "C:\\Capg\\Week05\\Day01\\Book1.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            // Skipping the header row
            reader.readNext();

            // Read each row
            while ((row = reader.readNext()) != null) {
                // Assuming Marks is in column index 3
                int marks = Integer.parseInt(row[3]);

                // Filter condition
                if (marks > 80) {
                    System.out.println("ID: " + row[0] + ", Name: " + row[1] +
                            ", Age: " + row[2] + ", Marks: " + marks);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (NumberFormatException | CsvValidationException e) {
            System.out.println("Error parsing marks: " + e.getMessage());
        }
    }
}
