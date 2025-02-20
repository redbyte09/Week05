package com.handsonpracticeproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

// Define a simple Java class (POJO)
class Student {
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters (needed for Jackson serialization)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
}
public class ListToJsonExample {
    public static void main(String[] args) {
        try {
            // Create a list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alica", 20, "A"));
            students.add(new Student("Bobby", 22, "B"));
            students.add(new Student("Charlie", 21, "A"));

            // Convert list to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(students);

            // Print JSON output
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
