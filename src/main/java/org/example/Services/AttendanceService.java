package org.example.Services;

import org.example.entities.Attendance;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee attendance
public class AttendanceService {

    // List to store attendance records
    private List<Attendance> attendanceList = new ArrayList<>();

    // Add a new attendance record
    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    // Find an attendance record using its ID
    public Attendance getAttendanceById(int attendanceId) {

        for (Attendance attendance : attendanceList) {

            if (attendance.getId() == attendanceId) {
                return attendance;
            }
        }

        return null;
    }

    // Return all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceList;
    }

    // Delete an attendance record using its ID
    public void deleteAttendance(int attendanceId) {

        attendanceList.removeIf(
                attendance -> attendance.getId() == attendanceId
        );
    }
}
