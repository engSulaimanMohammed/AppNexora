package org.example.Services;

import org.example.Entities.AuditTrail;
import org.example.Interfaces.AuditTrailService;

import java.util.ArrayList;
import java.util.List;

public class AuditTrailServiceImplAdmin implements AuditTrailService {

    private final List<AuditTrail> logs = new ArrayList<>();


    @Override
    public void log(String username, String action) {
        logs.add(
                new AuditTrail(username, action)
        );
    }

    @Override
    public List<AuditTrail> getAllLogs() {
        return new ArrayList<>(logs);
    }
}
