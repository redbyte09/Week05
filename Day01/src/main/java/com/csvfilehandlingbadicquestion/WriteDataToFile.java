package com.csvfilehandlingbadicquestion;

import com.opencsv.CSVWriter;
import java.io.FileWriter;


public class WriteDataToFile {
    public static void main(String[] args) {
        String file = "C:\\Capg\\Week05\\Day01\\Book2.csv";
       try (CSVWriter writer = new CSVWriter(new FileWriter(file))){

           String[] header ={"ID","Name","Department","Salary"};
           String[] bk1 = {"101","Unaiz","Finance","45000"};
           String[] bk2= {"102","Adarsh","Sales","25000"};
           String[] bk3= {"103","Pragya","CA","55000"};
           String[] bk4= {"104","Riya","Civil Engineer","50000"};
           String[] bk5= {"105","Sarah","Finance","50000"};
           writer.writeNext(header);
           writer.writeNext(bk1);
           writer.writeNext(bk2);
           writer.writeNext(bk3);
           writer.writeNext(bk4);
           writer.writeNext(bk5);
           System.out.println("CSV file written successfully using OpenCSV!");

        } catch (Exception e) {
           e.printStackTrace();
       }
        
    }
}
