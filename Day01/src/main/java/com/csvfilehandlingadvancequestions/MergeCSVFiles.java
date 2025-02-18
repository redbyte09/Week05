package com.csvfilehandlingadvancequestions;
//import
import java.io.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        // First file
        String file1 = "C:\\Capg\\Week05\\Day01\\Students1.csv";
        // Second file
        String file2 = "C:\\Capg\\Week05\\Day01\\Students2.csv";
        // Output file
        String outputFile = "C:\\Capg\\Week05\\Day01\\Merged.csv";

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            // Read header of first file
            String line1 = br1.readLine();
            // Read header of second file
            String line2 = br2.readLine();

            // Write merged header to output file
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            String row1, row2;
            while ((row1 = br1.readLine()) != null && (row2 = br2.readLine()) != null) {
                // Split both rows based on comma
                String[] data1 = row1.split(",");
                String[] data2 = row2.split(",");

                // Merge both rows
                String mergedRow = data1[0] + "," + data1[1] + "," + data1[2] + "," + data2[1] + "," + data2[2];
                bw.write(mergedRow);
                bw.newLine();
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

