package org.example.Interfaces;

import org.example.entities.Request;
import java.util.List;

public interface RequestService {

    void submitRequest(Request request);

    void approveRequest(int requestId);

    void rejectRequest(int requestId);

    Request getRequestById(int requestId);

    List<Request> getAllRequests();
}