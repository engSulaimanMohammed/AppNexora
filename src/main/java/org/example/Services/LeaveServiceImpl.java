package org.example.Services;

import org.example.Entities.Employee;
import org.example.Entities.LeaveRequest;
import org.example.Entities.LeaveStatus;
import org.example.Interfaces.EmployeeService;
import org.example.Interfaces.LeaveService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeaveServiceImpl implements LeaveService {

    private final EmployeeService employeeService;
    private final List<LeaveRequest> requests = new ArrayList<>();
    private int nextId = 1;

    public LeaveServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public LeaveRequest submit(int employeeId, String type, int days) {
        LeaveRequest request = new LeaveRequest(nextId++, employeeId, type, days);
        requests.add(request);
        return request;
    }

    @Override
    public List<LeaveRequest> findAll() {
        return List.copyOf(requests);
    }

    @Override
    public List<LeaveRequest> findByEmployee(int employeeId) {
        return requests.stream()
                .filter(r -> r.getEmployeeId() == employeeId)
                .toList();
    }

    @Override
    public List<LeaveRequest> findPending() {
        return requests.stream()
                .filter(r -> r.getStatus() == LeaveStatus.PENDING)
                .toList();
    }

    @Override
    public boolean decide(int requestId, boolean approve) {
        Optional<LeaveRequest> match = requests.stream()
                .filter(r -> r.getId() == requestId && r.getStatus() == LeaveStatus.PENDING)
                .findFirst();

        if (match.isEmpty()) {
            return false;
        }

        LeaveRequest request = match.get();
        if (approve) {
            request.setStatus(LeaveStatus.APPROVED);
            employeeService.findById(request.getEmployeeId())
                    .ifPresent(e -> e.setLeaveBalance(e.getLeaveBalance() - request.getDays()));
        } else {
            request.setStatus(LeaveStatus.REJECTED);
        }
        return true;
    }
}
