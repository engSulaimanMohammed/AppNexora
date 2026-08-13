package org.example.Services;

import org.example.entities.Leave;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee leave requests
public class LeaveService {

    // List to store leave requests
    private List<Leave> leaveList = new ArrayList<>();

    // Add a new leave request
    public void addLeave(Leave leave) {
        leaveList.add(leave);
    }

    // Find a leave request using its ID
    public Leave getLeaveById(int leaveId) {

        // Check every leave request in the list
        for (Leave leave : leaveList) {

            // Check if the leave ID matches
            if (leave.getId() == leaveId) {
                return leave;
            }
        }

        // Return null if the leave request is not found
        return null;
    }

    // Return all leave requests
    public List<Leave> getAllLeaves() {
        return leaveList;
    }

    // Update an existing leave request
    public void updateLeave(Leave updatedLeave) {

        for (int i = 0; i < leaveList.size(); i++) {

            if (leaveList.get(i).getId() == updatedLeave.getId()) {
                leaveList.set(i, updatedLeave);
                return;
            }
        }
    }

    // Delete a leave request using its ID
    public void deleteLeave(int leaveId) {

        leaveList.removeIf(
                leave -> leave.getId() == leaveId
        );
    }
}