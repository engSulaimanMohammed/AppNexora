package org.example.Utils;

import org.example.Entities.Document;

public class DocumentService {
    public void uploadDocument(Document document) {
        // Store uploaded employee files
        System.out.println("File uploaded: " + document.getFileName());
    }
}
