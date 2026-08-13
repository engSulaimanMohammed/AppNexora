package org.example.Entities;

import java.time.LocalDate;

public class Request {

    private int requestId;
    private int employeeId;
    private String requestType;
    private LocalDate requestDate;
    private String description;
    private String status;

    public Request(
            int requestId,
            int employeeId,
            String requestType,
            LocalDate requestDate,
            String description,
            String status) {

        this.requestId = requestId;
        this.employeeId = employeeId;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.description = description;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}