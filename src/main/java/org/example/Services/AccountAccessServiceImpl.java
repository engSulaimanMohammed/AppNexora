package org.example.Services;

import org.example.Interfaces.AccountAccessService;

import java.util.HashMap;
import java.util.Map;

public class AccountAccessServiceImpl implements AccountAccessService {

    private final Map<String, String> accounts = new HashMap<>();

    public AccountAccessServiceImpl() {
        accounts.put("admin", "admin123");
    }


    @Override
    public boolean login(String username, String password) {
        return accounts.containsKey(username)
                && accounts.get(username).equals(password);
    }

    @Override
    public void addAccount(String username, String password) {
        if (accountExists(username)) {
            throw new IllegalArgumentException(
                    "Username already exists.");

        }
    }

    @Override
    public boolean accountExists(String username) {
        return accounts.containsKey(username);
    }
}
