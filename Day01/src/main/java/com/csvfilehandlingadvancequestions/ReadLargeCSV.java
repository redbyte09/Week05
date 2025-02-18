package com.csvfilehandlingadvancequestions;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        // CSV file path
        String filePath = "C:\\Capg\\Week05\\Day01\\Merged.csv";
        // Process 100 lines at a time
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header row
            br.readLine();

            while ((line = br.readLine()) != null) {
                recordCount++;

                // Process the line (For now, just print the record number)
                System.out.println("Processing Record: " + recordCount);

                // Display count after processing every 100 records
                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records so far...");
                }
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

