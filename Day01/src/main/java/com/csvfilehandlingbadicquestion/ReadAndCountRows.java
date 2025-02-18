package com.csvfilehandlingbadicquestion;

//import
import com.opencsv.CSVReader;

import java.io.FileReader;
//class
public class ReadAndCountRows {
    public static void main(String[] args) {
        //path of the file
        String line="C:\\Capg\\Week05\\Day01\\Book1.csv";
        //initialize count with 0
        int count=0;
        //using try catch block to handle exception
        try(CSVReader reader = new CSVReader(new FileReader(line))){
           reader.readNext();
           while(reader.readNext() !=null){
               count++;
           }
            System.out.println("number of rows"+count);

        }
        catch (Exception e){
            System.out.println("error in reading the file" +e.getMessage());
        }

    }
}
