package com.handsonpracticeproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class ReadJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into a JsonNode tree
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Iterate through keys and print values
            Iterator<String> fieldNames = rootNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = rootNode.get(fieldName);
                System.out.println(fieldName + " : " + fieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

