package com.mcb.creditfactory;

import com.google.gson.Gson;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;

import java.math.BigDecimal;

@SpringBootApplication
public class TestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }
}
