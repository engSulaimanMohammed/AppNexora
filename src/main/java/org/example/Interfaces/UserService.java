package org.example.Interfaces;

import org.example.Entities.User;

public interface UserService {

    /** Returns the matching user, or {@code null} when the credentials are invalid. */
    User authenticate(String username, String password);

    /** Sets a new password for the given username. Returns {@code false} if the user is unknown. */
    boolean resetPassword(String username, String newPassword);

    void resetPassword(User user);
}
