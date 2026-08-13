package org.example.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private int attendanceId;
    private int employeeId;

    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;

    private String status;
    private boolean remote;

    public Attendance(
            int attendanceId,
            int employeeId,
            LocalDate date,
            LocalTime checkIn,
            LocalTime checkOut,
            String status,
            boolean remote) {

        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.remote = remote;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public String getStatus() {
        return status;
    }

    public boolean isRemote() {
        return remote;
    }
}