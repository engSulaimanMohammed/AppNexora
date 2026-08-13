package org.example.Services;

import org.example.Entities.Attendance;

public class AttendanceServiceImp extends AttendanceService {
    @Override
    public void recordClockIn(Long employeeId) {
        // Step 1: Logic to register timestamp when an employee logs in
        System.out.println("Employee ID " + employeeId + " clocked in successfully.");
    }

    @Override
    public Attendance getAttendance(Long employeeId) {
        // Step 2: Retrieve employee attendance history
        return new Attendance(1L, employeeId, "2026-08-12", "Present");
    }

}
