package org.example.Services;


import org.example.entities.Request;
import org.example.interfaces.RequestService;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee requests
public class RequestServiceImpl implements RequestService {

    // List to store employee requests
    private List<Request> requestList = new ArrayList<>();

    // Submit a new employee request
    @Override
    public void submitRequest(Request request) {
        requestList.add(request);
    }

    // Approve a request using its ID
    @Override
    public void approveRequest(int requestId) {

        Request request = getRequestById(requestId);

        if (request != null) {
            request.setStatus("APPROVED");
        }
    }

    // Reject a request using its ID
    @Override
    public void rejectRequest(int requestId) {

        Request request = getRequestById(requestId);

        if (request != null) {
            request.setStatus("REJECTED");
        }
    }

    // Find a request using its ID
    @Override
    public Request getRequestById(int requestId) {

        for (Request request : requestList) {

            if (request.getRequestId() == requestId) {
                return request;
            }
        }

        return null;
    }

    // Return all employee requests
    @Override
    public List<Request> getAllRequests() {
        return requestList;
    }
}