package org.example.Services;
import org.example.Entities.LeaveRequestHR;
import org.example.Interfaces.LeaveServiceHR;
import java.util.ArrayList;
import java.util.List;
public abstract class LeaveServiceImpl implements LeaveServiceHR {
    private final List<LeaveRequestHR> leaves =
            new ArrayList<>();

    @Override
    public void submitLeave(LeaveRequestHR leave) {

        if (leave != null) {
            leaves.add(leave);
        }
    }

    @Override
    public List<LeaveRequestHR> getAllLeaves() {
        return new ArrayList<>(leaves);
    }

    @Override
    public List<LeaveRequestHR> getPendingLeaves() {

        List<LeaveRequestHR> result =
                new ArrayList<>();

        for (LeaveRequestHR leave : leaves) {

            if ("PENDING".equalsIgnoreCase(
                    leave.getStatus())) {

                result.add(leave);
            }
        }

        return result;
    }

    @Override
    public boolean approveLeave(
            int id,
            int userId) {

        for (LeaveRequestHR leave : leaves) {

            if (leave.getLeaveId() == id
                    && "PENDING".equalsIgnoreCase(
                    leave.getStatus())) {

                leave.setStatus("APPROVED");
                leave.setApprovedBy(userId);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean rejectLeave(
            int id,
            int userId) {

        for (LeaveRequestHR leave : leaves) {

            if (leave.getLeaveId() == id
                    && "PENDING".equalsIgnoreCase(
                    leave.getStatus())) {

                leave.setStatus("REJECTED");
                leave.setApprovedBy(userId);

                return true;
            }
        }

        return false;
    }
}

