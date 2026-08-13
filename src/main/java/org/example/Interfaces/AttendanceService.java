package org.example.Interfaces;

import org.example.Entities.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    void addAttendance(Attendance attendance);

    Attendance getAttendanceById(int attendanceId);

    List<Attendance> getAllAttendance();

    List<Attendance> getAttendanceByEmployee(int employeeId);

    List<Attendance> getAttendanceByDate(LocalDate date);

    boolean updateAttendance(Attendance attendance);

    boolean deleteAttendance(int attendanceId);

    int getPresentCount(LocalDate date);

    int getLateCount(LocalDate date);

    int getMissingCheckoutCount(LocalDate date);

    double getAttendancePercentage(LocalDate date);
}
