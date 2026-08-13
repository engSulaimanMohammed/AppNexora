package org.example.Entities;

public abstract class AttendanceAdmin {
    private Long id;
    private Long employeeId;
    private String date;
    private String status;


    public AttendanceAdmin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public abstract void recordClockIn(Long employeeId);

    public abstract Attendance getAttendance(Long employeeId);
}
