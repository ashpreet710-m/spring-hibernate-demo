package com.example.demo.transaction;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final AccountDAO accountDAO = new AccountDAO();

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = accountDAO.getAccount(fromId);
        Account to = accountDAO.getAccount(toId);

        if (from.getBalance() < amount)
            throw new RuntimeException("Insufficient balance!");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountDAO.updateAccount(from);
        accountDAO.updateAccount(to);
    }
}
