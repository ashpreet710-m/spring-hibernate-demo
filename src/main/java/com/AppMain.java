package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.di.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = context.getBean(Student.class);
        student.showInfo();
        context.close();
    }
}
