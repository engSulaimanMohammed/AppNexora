package org.example.Interfaces;

import org.example.Entities.Attendance;
import org.example.Entities.AttendanceStatus;

import java.util.List;

public interface AttendanceService {

    Attendance mark(int employeeId, AttendanceStatus status);

    List<Attendance> findAll();

    List<Attendance> findByEmployee(int employeeId);
}
