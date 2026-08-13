package org.example.Services;


import org.example.Entities.SchedulePolicy;

import java.util.ArrayList;
import java.util.List;

public class SchedulePolicyService {

    private final List<SchedulePolicy> policies = new ArrayList<>();

    public void addPolicy(SchedulePolicy policy) {
        policies.add(policy);
    }

    public List<SchedulePolicy> getAllPolicies() {
        return new ArrayList<>(policies);
    }
}

