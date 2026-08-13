package org.example.Services;

import java.util.HashMap;
import java.util.Map;

public class AccountAccessServiceImpl implements AccountAccessService{

    private final Map<String, String> accounts = new HashMap<>();

    public AccountAccessServiceImpl() {
        accounts.put("admin", "admin123");
    }


}
