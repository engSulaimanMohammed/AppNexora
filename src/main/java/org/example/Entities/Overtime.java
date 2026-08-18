package org.example.Entities;

import java.time.LocalDate;

public class Overtime {

    private int overtimeId;
    private int employeeId;
    private LocalDate date;
    private double hours;
    private String reason;
    private String status;

    public Overtime(
            int overtimeId,
            int employeeId,
            LocalDate date,
            double hours,
            String reason,
            String status) {

        this.overtimeId = overtimeId;
        this.employeeId = employeeId;
        this.date = date;
        this.hours = hours;
        this.reason = reason;
        this.status = status;
    }

    public int getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(int overtimeId) {
        this.overtimeId = overtimeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}