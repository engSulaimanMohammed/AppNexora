package org.example.Interfaces;

import org.example.Entities.LeaveRequest;

public interface LeaveManagementService {
    void applyLeave(LeaveRequest request);

    void updateLeaveStatus(Long requestId, String status);

}
