package org.example.Interfaces;

import org.example.Entities.AttendanceAdmin;

public interface AttendanceService implements AttendanceAdmin {
    @Override
    public void recordClockIn(Long employeeId) {
        // Implementation goes here.
    }

    @Override
    public Attendance getAttendance(Long employeeId) {
        // Implementation goes here.
        return null;
    }

}
