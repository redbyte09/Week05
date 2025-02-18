package com.csvfilehandlingadvancequestions;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        // CSV file path
        String filePath = "C:\\Capg\\Week05\\Day01\\Student.csv";
        // To store unique IDs
        Set<String> seenIds = new HashSet<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header row
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] data = line.split(",");
                // Assuming ID is the first column in the CSV
                String id = data[0];

                // Check if this ID is already encountered
                if (seenIds.contains(id)) {
                    // Print duplicate record
                    System.out.println("Duplicate Record: " + line);
                } else {
                    // Add the ID to the set
                    seenIds.add(id);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

