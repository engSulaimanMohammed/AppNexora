package org.example.Services;

import org.example.entities.Document;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee documents
public class DocumentService {

    // List to store employee documents
    private List<Document> documentList = new ArrayList<>();

    // Add a new document
    public void addDocument(Document document) {
        documentList.add(document);
    }

    // Find a document using its ID
    public Document getDocumentById(int documentId) {

        // Check every document in the list
        for (Document document : documentList) {

            // Check if the document ID matches
            if (document.getDocumentId() == documentId) {
                return document;
            }
        }

        // Return null if the document is not found
        return null;
    }

    // Return all documents
    public List<Document> getAllDocuments() {
        return documentList;
    }

    // Update an existing document
    public void updateDocument(Document updatedDocument) {

        for (int i = 0; i < documentList.size(); i++) {

            if (documentList.get(i).getDocumentId()
                    == updatedDocument.getDocumentId()) {

                documentList.set(i, updatedDocument);
                return;
            }
        }
    }

    // Delete a document using its ID
    public void deleteDocument(int documentId) {

        documentList.removeIf(
                document -> document.getDocumentId() == documentId
        );
    }
}