package org.example.Services;

import org.example.entities.Overtime;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee overtime
public class OvertimeService {

    // List to store overtime records
    private List<Overtime> overtimeList = new ArrayList<>();

    // Add a new overtime record
    public void addOvertime(Overtime overtime) {
        overtimeList.add(overtime);
    }

    // Find an overtime record using its ID
    public Overtime getOvertimeById(int overtimeId) {

        // Check every overtime record in the list
        for (Overtime overtime : overtimeList) {

            // Check if the overtime ID matches
            if (overtime.getOvertimeId() == overtimeId) {
                return overtime;
            }
        }

        // Return null if the overtime record is not found
        return null;
    }

    // Return all overtime records
    public List<Overtime> getAllOvertime() {
        return overtimeList;
    }

    // Return all overtime records for a specific employee
    public List<Overtime> getOvertimeByEmployee(int employeeId) {

        // Create a list for the employee overtime records
        List<Overtime> employeeOvertime = new ArrayList<>();

        // Check every overtime record
        for (Overtime overtime : overtimeList) {

            // Add overtime records that belong to the employee
            if (overtime.getEmployeeId() == employeeId) {
                employeeOvertime.add(overtime);
            }
        }

        return employeeOvertime;
    }

    // Update an existing overtime record
    public void updateOvertime(Overtime updatedOvertime) {

        for (int i = 0; i < overtimeList.size(); i++) {

            if (overtimeList.get(i).getOvertimeId()
                    == updatedOvertime.getOvertimeId()) {

                overtimeList.set(i, updatedOvertime);
                return;
            }
        }
    }

    // Approve an overtime request
    public void approveOvertime(int overtimeId) {

        Overtime overtime = getOvertimeById(overtimeId);

        if (overtime != null) {
            overtime.setStatus("APPROVED");
        }
    }

    // Reject an overtime request
    public void rejectOvertime(int overtimeId) {

        Overtime overtime = getOvertimeById(overtimeId);

        if (overtime != null) {
            overtime.setStatus("REJECTED");
        }
    }

    // Delete an overtime record using its ID
    public void deleteOvertime(int overtimeId) {

        overtimeList.removeIf(
                overtime -> overtime.getOvertimeId() == overtimeId
        );
    }
}