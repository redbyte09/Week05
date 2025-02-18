package com.csvfilehandlingintermediatequestions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class EmployeeDetails {
    public static void main(String[] args) {
        // File path
        String file = "C:\\Capg\\Week05\\Day01\\Employee.csv";

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] row;
            // Skip header row
            reader.readNext();

            // Store row data
            while ((row = reader.readNext()) != null) {
                String name = row[0];

                // Case-insensitive comparison
                if (name.equalsIgnoreCase("pragya")) {
                    System.out.println("Name: " + row[0] + ", Department: " + row[1] + ", Salary: " + row[2]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
