package com.csvfilehandlingbadicquestion;

//import
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;

//create class here
public class FileReadAnPrint {
    public static void main(String[] args) {
        //give path of the csv file here
        String file = "C:\\Capg\\Week05\\Day01\\Book1.csv";
        //using try catch block here
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            //using loop to check that we have line left or not
            while((line=br.readLine()) != null){
                String[] data = line.split(",");
                System.out.println("ID:" +data[0] + ", Name:"+data[1] + ", Age:"+data[2]);
            }
            //catch block here
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
