package org.example.Utils;

import org.example.Interfaces.AuditTrailService;

public class AuditTrailServiceImpl implements AuditTrailService {


        @Override
        public void logAction(String action, String performedBy) {
            // Record all critical system changes for auditing
            System.out.println("[AUDIT] Action: " + action + " | Performed By: " + performedBy);
        }
    }


