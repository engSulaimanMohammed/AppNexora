package org.example.Entities;

import java.time.LocalDate;

public class Attendance {

    private final int id;
    private final int employeeId;
    private final LocalDate date;
    private final AttendanceStatus status;

    public Attendance(int id, int employeeId, LocalDate date, AttendanceStatus status) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }
}
