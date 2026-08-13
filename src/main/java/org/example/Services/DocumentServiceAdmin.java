package org.example.Services;

import org.example.Entities.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentServiceAdmin {

    private final List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
    }
}
