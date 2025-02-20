package com.handsonpracticeproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonData {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into a JsonNode array
            JsonNode rootNode = objectMapper.readTree(new File("users.json"));

            // Iterate through JSON array
            for (JsonNode user : rootNode) {
                int age = user.get("age").asInt(); // Get age field
                if (age > 25) {  // Filter users older than 25
                    System.out.println(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

