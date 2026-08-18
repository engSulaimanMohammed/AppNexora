package org.example.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private int id;
    private int employeeId;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private String status;

    public Attendance(
            int id,
            int employeeId,
            LocalDate date,
            LocalTime checkIn,
            LocalTime checkOut,
            String status) {

        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;


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

    public void setId(int id) {
        this.id = id;
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

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
    public AttendanceStatus getStatus() {
        return status;
    }

}}
