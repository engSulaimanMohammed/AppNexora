package org.example.Entities;

public class LeaveRequest {

    private final int id;
    private final int employeeId;
    private final String type;
    private final int days;
    private LeaveStatus status;

    public LeaveRequest(int id, int employeeId, String type, int days) {
        this.id = id;
        this.employeeId = employeeId;
        this.type = type;
        this.days = days;
        this.status = LeaveStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getType() {
        return type;
    }

    public int getDays() {
        return days;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }
}
