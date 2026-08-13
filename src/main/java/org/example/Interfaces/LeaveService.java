package org.example.Interfaces;

import org.example.Entities.LeaveRequest;

import java.util.List;

public interface LeaveService {

    void submitLeave(LeaveRequest leaveRequest);

    LeaveRequest getLeaveById(int leaveId);

    List<LeaveRequest> getAllLeaves();

    List<LeaveRequest> getEmployeeLeaves(int employeeId);

    List<LeaveRequest> getPendingLeaves();

    boolean approveLeave(int leaveId, int approvedBy);

    boolean rejectLeave(int leaveId, int approvedBy);

    boolean cancelLeave(int leaveId);

    int getPendingLeaveCount();
}
