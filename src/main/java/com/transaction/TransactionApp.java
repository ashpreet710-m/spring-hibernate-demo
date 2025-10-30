package com.example.demo.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.config.SpringConfig;

public class TransactionApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BankService service = context.getBean(BankService.class);

        try {
            service.transfer(1, 2, 500);
            System.out.println("Transaction successful!");
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        context.close();
    }
}
