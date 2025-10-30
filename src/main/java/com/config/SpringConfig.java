package com.example.demo.config;

import com.example.demo.di.Course;
import com.example.demo.di.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Course course() {
        return new Course();
    }

    @Bean
    public Student student() {
        return new Student(course());
    }
}
