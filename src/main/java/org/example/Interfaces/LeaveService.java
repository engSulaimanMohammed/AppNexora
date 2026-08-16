package org.example.Interfaces;

import org.example.Entities.LeaveRequest;

import java.util.List;

public interface LeaveService {

    LeaveRequest submit(int employeeId, String type, int days);

    List<LeaveRequest> findAll();

    List<LeaveRequest> findByEmployee(int employeeId);

    List<LeaveRequest> findPending();

    /**
     * Approves or rejects a pending request. Approving also deducts the days
     * from the employee's leave balance. Returns {@code false} when the request
     * does not exist or is no longer pending.
     */
    boolean decide(int requestId, boolean approve, String reason);
}
