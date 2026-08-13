package org.example.Entities;

import java.time.LocalTime;

public class WorkSchedule {

    private int scheduleId;
    private int employeeId;
    private LocalTime startTime;
    private LocalTime endTime;
    private int breakHours;

    public WorkSchedule(
            int scheduleId,
            int employeeId,
            LocalTime startTime,
            LocalTime endTime,
            int breakHours) {

        this.scheduleId = scheduleId;
        this.employeeId = employeeId;
        this.startTime = startTime;
        this.endTime = endTime;
