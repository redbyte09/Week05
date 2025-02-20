package com.practiceproblemslisttoarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonExample {
    public static void main(String[] args) {
        try {
            // Create a list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alica", 20, "A"));
            students.add(new Student("Bobby", 22, "B"));
            students.add(new Student("Chahat", 21, "A"));

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
