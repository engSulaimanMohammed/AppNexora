package org.example.Interfaces;
import org.example.Entities.AttendanceHR;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceServiceHR {

    void addAttendance(AttendanceHR attendance);

    List<AttendanceHR> getAllAttendance();

    int getPresentCount(LocalDate date);

    int getLateCount(LocalDate date);

    int getMissingCheckoutCount(LocalDate date);

    double getAttendancePercentage(
            LocalDate date,
            int totalEmployees);
}
