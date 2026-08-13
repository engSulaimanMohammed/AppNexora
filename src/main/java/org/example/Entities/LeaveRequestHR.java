package org.example.Entities;

import java.time.LocalDate;

public class LeaveRequestHR {

    private int leaveId;
    private int employeeId;
    private int approvedBy;

    private String leaveType;
    private String reason;
    private String status;

    private LocalDate startDate;
    private LocalDate endDate;

    public LeaveRequestHR(
            int leaveId,
            int employeeId,
            String leaveType,
            LocalDate startDate,
            LocalDate endDate,
            String reason,
            String status,
            int approvedBy) {

        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
        this.approvedBy = approvedBy;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }
}