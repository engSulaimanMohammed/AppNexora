package org.example.Interfaces;

import org.example.Entities.Attendance;
import org.example.Entities.AttendanceAdmin;

public interface AttendanceService implements AttendanceAdmin {
    // Record clock-in time for an employee
    void recordClockIn(Long employeeId);

    // Retrieve attendance status by employee ID
    Attendance getAttendance(Long employeeId);

}
