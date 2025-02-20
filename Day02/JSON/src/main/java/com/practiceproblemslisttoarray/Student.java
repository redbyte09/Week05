package com.practiceproblemslisttoarray;

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

    // Getters (Jackson needs them for serialization)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }
}
