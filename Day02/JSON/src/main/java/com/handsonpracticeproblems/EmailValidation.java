package com.handsonpracticeproblems;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;

public class EmailValidation {
    public static void main(String[] args) {
        try {
            // Load JSON Schema from file
            FileInputStream schemaStream = new FileInputStream(new File("schema.json"));
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            // Sample JSON object (Valid)
            JSONObject validJson = new JSONObject("{\"email\": \"test@example.com\"}");

            // Sample JSON object (Invalid)
            JSONObject invalidJson = new JSONObject("{\"email\": \"invalid-email\"}");

            // Validate valid email
            try {
                schema.validate(validJson);
                System.out.println("Valid email: " + validJson);
            } catch (Exception e) {
                System.out.println("Invalid email: " + validJson);
                e.printStackTrace();
            }

            // Validate invalid email
            try {
                schema.validate(invalidJson);
                System.out.println("Valid email: " + invalidJson);
            } catch (Exception e) {
                System.out.println("Invalid email: " + invalidJson);
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

