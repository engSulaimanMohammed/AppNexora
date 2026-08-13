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
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

