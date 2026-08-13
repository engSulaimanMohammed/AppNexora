package org.example.Interfaces;

public interface AccountAccessService {

    boolean login(String username, String password);

    void addAccount(String username, String password);

    boolean accountExists(String username);
}
