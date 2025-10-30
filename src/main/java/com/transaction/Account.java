package com.example.demo.transaction;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String holderName;
    private double balance;

    public Account() {}
    public Account(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getId() { return id; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
