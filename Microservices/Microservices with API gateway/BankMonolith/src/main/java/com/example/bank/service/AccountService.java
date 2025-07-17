package com.example.bank.service;

import com.example.bank.model.Account;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private final Map<Long, Account> accountMap = new HashMap<>();

    @PostConstruct
    public void init() {
        accountMap.put(1L, new Account(1L, "Alice", 10000));
        accountMap.put(2L, new Account(2L, "Bob", 5000));
        accountMap.put(3L, new Account(3L, "Charlie", 3000));
    }

    public String getBalance(Long id) {
        try {
            Thread.sleep(200); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Account account = accountMap.get(id);
        return account != null ? "Balance: Rs." + account.getBalance() : "Account not found";
    }
}
