package com.csvfilehandlingintermediatequestions;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class ModifyCSVFile {
    public static void main(String[] args) {
        // File path
        String file = "C:\\Capg\\Week05\\Day01\\Employee.csv";

        try (
                CSVReader reader = new CSVReader(new FileReader(file));
                CSVWriter writer = new CSVWriter(new FileWriter("C:\\Capg\\Week05\\Day01\\temp.csv"))
        ) {
            String[] row;
            // Read header
            row = reader.readNext();
            // Write header to new file
            writer.writeNext(row);

            while ((row = reader.readNext()) != null) {
                // Get department
                String department = row[1];

                if (department.equalsIgnoreCase("IT")) {
                    // Convert salary to double
                    double salary = Double.parseDouble(row[2]);
                    // Increase salary by 10%
                    salary *= 1.10;
                    // Format salary
                    row[2] = String.format("%.2f", salary);
                }

                // Write updated row
                writer.writeNext(row);
            }
        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // Replace the original file with the updated file
        File originalFile = new File(file);
        File tempFile = new File("C:\\Capg\\Week05\\Day01\\temprary.csv");

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            System.out.println("CSV file updated successfully.");
        } else {
            System.out.println("Error updating CSV file.");
        }
    }
}
