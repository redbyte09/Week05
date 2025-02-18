package com.csvfilehandlingadvancequestions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//  Create Student class
class Student {
    String name;
    int age;
    int marks;

    // Constructor
    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Override toString() for printing
    @Override
    public String toString() {
        return "Student{Name: '" + name + "', Age: " + age + ", Marks: " + marks + "}";
    }
}

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        // CSV file path
        String file = "C:\\Capg\\Week05\\Day01\\Student.csv";
        // List to store Student objects
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            // Skip header row
            reader.readNext();
            String[] row;

            //  Read each row and create Student object
            while ((row = reader.readNext()) != null) {
                String name = row[0];
                int age = Integer.parseInt(row[1]);
                int marks = Integer.parseInt(row[2]);

                // Create object
                Student student = new Student(name, age, marks);
                // Add object to list
                students.add(student);
            }

            // Print all Student objects
            System.out.println("List of Students:");
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in number conversion: " + e.getMessage());
        }
    }
}

