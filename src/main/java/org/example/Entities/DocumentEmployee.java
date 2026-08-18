package org.example.Entities;

import java.time.LocalDate;

public class Document {

    private int documentId;
    private int employeeId;
    private String documentName;
    private String documentType;
    private String status;
    private LocalDate expiryDate;

    public Document(
            int documentId,
            int employeeId,
            String documentName,
            String documentType,
            String status,
            LocalDate expiryDate) {

        this.documentId = documentId;
        this.employeeId = employeeId;
        this.documentName = documentName;
        this.documentType = documentType;
        this.status = status;
        this.expiryDate = expiryDate;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}