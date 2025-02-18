package com.csvfilehandlingintermediatequestions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class SortCSVFile {
    public static void main(String[] args) {
        // Given CSV file path
        String file = "C:\\Capg\\Week05\\Day01\\temp.csv";

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            // Array to store records
            String[] employees = new String[6];
            int count = 0;

            // Skip header row
            reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null) {
                // Store as single string
                employees[count] = row[0] + "," + row[1] + "," + row[2];
                count++;
            }

            // Sorting salaries in Descending Order (Bubble Sort)
            for (int i = 0; i < count - 1; i++) {
                for (int j = i + 1; j < count; j++) {
                    int salary1 = Integer.parseInt(employees[i].split(",")[2]);
                    int salary2 = Integer.parseInt(employees[j].split(",")[2]);

                    if (salary1 < salary2) {
                        // Swap
                        String temp = employees[i];
                        employees[i] = employees[j];
                        employees[j] = temp;
                    }
                }
            }

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, count); i++) {
                String[] data = employees[i].split(",");
                System.out.println("Name: " + data[0] + ", Department: " + data[1] + ", Salary: " + data[2]);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
