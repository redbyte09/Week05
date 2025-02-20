package com.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArrayExample {
    public ListToJsonArrayExample() {
    }

    public static void main(String[] args) {
        try {
            List<Car> carList = Arrays.asList(new Car("Toyota", "Camry", 2022), new Car("Honda", "Civic", 2021), new Car("Ford", "Mustang", 2023));
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(carList);
            System.out.println(jsonArray);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}