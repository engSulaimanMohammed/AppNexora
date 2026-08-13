package org.example.Interfaces;

import org.example.Entities.Attendance;

public interface AttendanceServiceAdmin extends AttendanceService {
    void recordClockIn(Long employeeId);
    Attendance getAttendance(Long employeeId);
}
