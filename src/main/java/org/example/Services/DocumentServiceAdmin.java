package org.example.Services;

import org.example.Entities.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentServiceAdmin {

    private final List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
    }

    public List<Document> getAllDocuments() {
        return new ArrayList<>(documents);
    }

    public List<Document> getEmployeeDocuments(int employeeId) {

        List<Document> result = new ArrayList<>();

        for (Document document : documents) {
            if (document.getEmployeeId() == employeeId) {
                result.add(document);
            }
        }

        return result;
    }
}

