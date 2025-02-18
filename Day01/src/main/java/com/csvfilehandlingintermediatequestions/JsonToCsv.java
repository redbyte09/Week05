package com.csvfilehandlingintermediatequestions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class JsonToCsv {
    public static void main(String[] args) {
        String jsonFile = "C:\\Capg\\Week05\\Day01\\File.json";
        String csvFile = "C:\\Capg\\Week05\\Day01\\S.csv";

        try {
            // Create ObjectMapper instance to read JSON
            ObjectMapper objectMapper = new ObjectMapper();
            // Read JSON file into a list of Student objects
            List<Student> students = objectMapper.readValue(new File(jsonFile), objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));

            // Create CSVWriter instance
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

            // Write header
            String[] header = { "ID", "Name", "Age", "Grade" };
            writer.writeNext(header);

            // Write student data
            for (Student student : students) {
                String[] record = { String.valueOf(student.getId()), student.getName(), String.valueOf(student.getAge()), student.getGrade() };
                writer.writeNext(record);
            }

            writer.close();
            System.out.println("CSV file generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Student class to map JSON data
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

