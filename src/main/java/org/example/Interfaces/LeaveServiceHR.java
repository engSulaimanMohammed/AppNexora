package org.example.Interfaces;

import org.example.Entities.LeaveRequestHR;

import java.util.List;

public interface LeaveServiceHR {

    void submitLeave(LeaveRequestHR leave);

    List<LeaveRequestHR> getAllLeaves();

    List<LeaveRequestHR> getPendingLeaves();

    boolean approveLeave(int id, int userId);

    boolean rejectLeave(int id, int userId);
}
