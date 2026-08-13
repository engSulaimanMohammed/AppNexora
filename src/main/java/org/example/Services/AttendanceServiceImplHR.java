package org.example.Services;

import org.example.Entities.AttendanceHR;
import org.example.Interfaces.AttendanceServiceHR;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AttendanceServiceImplHR implements AttendanceServiceHR {
    private final List<AttendanceHR> attendanceList =
            new ArrayList<>();

    @Override
    public void addAttendance(AttendanceHR attendance) {

        if (attendance != null) {
            attendanceList.add(attendance);
        }
    }

    @Override
    public List<AttendanceHR> getAllAttendance() {
        return new ArrayList<>(attendanceList);
    }

    @Override
    public int getPresentCount(LocalDate date) {

        int count = 0;

        for (AttendanceHR attendance : attendanceList) {

            if (date.equals(attendance.getDate())
                    && ("PRESENT".equalsIgnoreCase(attendance.getStatus())
                    || "LATE".equalsIgnoreCase(attendance.getStatus()))) {

                count++;
            }
        }

        return count;
    }

    @Override
    public int getLateCount(LocalDate date) {

        int count = 0;

        for (AttendanceHR attendance : attendanceList) {

            if (date.equals(attendance.getDate())
                    && "LATE".equalsIgnoreCase(attendance.getStatus())) {

                count++;
            }
        }

        return count;
    }

    @Override
    public int getMissingCheckoutCount(LocalDate date) {

        int count = 0;

        for (AttendanceHR attendance : attendanceList) {

            if (date.equals(attendance.getDate())
                    && attendance.getCheckOut() == null) {

                count++;
            }
        }

        return count;
    }

    @Override
    public double getAttendancePercentage(
            LocalDate date,
            int totalEmployees) {

        if (totalEmployees == 0) {
            return 0;
        }

        return getPresentCount(date) * 100.0 / totalEmployees;
    }
}
