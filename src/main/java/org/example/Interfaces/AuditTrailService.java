package org.example.Interfaces;

import org.example.Entities.AuditTrail;

import java.util.List;

public interface AuditTrailService {

    void log(String username, String action);

    List<AuditTrail> getAllLogs();
}
