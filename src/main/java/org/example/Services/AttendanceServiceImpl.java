package org.example.Services;

import org.example.Entities.Attendance;
import org.example.Entities.AttendanceStatus;
import org.example.Interfaces.AttendanceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceServiceImpl
        implements AttendanceService {

    private final List<Attendance> records =
            new ArrayList<>();

    private int nextId = 1;


    @Override
    public Attendance mark(
            int employeeId,
            AttendanceStatus status) {

        LocalDate today =
                LocalDate.now();


        boolean alreadyExists =
                records.stream()
                        .anyMatch(record ->
                                record.getEmployeeId() == employeeId
                                        &&
                                        record.getDate()
                                                .equals(today)
                        );


        if (alreadyExists) {

            throw new IllegalStateException(
                    "Attendance already recorded for this employee today."
            );
        }


        Attendance record =
                new Attendance(
                        nextId++,
                        employeeId,
                        today,
                        status
                );


        records.add(record);

        return record;
    }


    @Override
    public List<Attendance> findAll() {

        return List.copyOf(records);
    }


    @Override
    public List<Attendance> findByEmployee(
            int employeeId) {

        return records.stream()
                .filter(record ->
                        record.getEmployeeId()
                                == employeeId
                )
                .toList();
    }
}