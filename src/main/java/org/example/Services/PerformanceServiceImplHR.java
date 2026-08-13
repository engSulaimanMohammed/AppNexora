package org.example.Services;
import org.example.Entities.PerformanceHR;
import org.example.Interfaces.PerformanceServiceHR;

import java.util.ArrayList;
import java.util.List;

public class PerformanceServiceImplHR implements PerformanceServiceHR{

    private final List<PerformanceHR> performances = new ArrayList<>();

    @Override
    public void addPerformance(PerformanceHR performance) {

        if (performance != null) {

            performance.setRating(
                    PerformanceHR.calculateRating(
                            performance.getScore()
                    )
            );

            performances.add(performance);
        }
    }

    @Override
    public List<PerformanceHR> getAllPerformance() {
        return new ArrayList<>(performances);
    }

    @Override
    public List<PerformanceHR> getEmployeePerformance(int employeeId) {

        List<PerformanceHR> result = new ArrayList<>();

        for (PerformanceHR performance : performances) {

            if (performance.getEmployeeId() == employeeId) {
                result.add(performance);
            }
        }

        return result;
    }

    @Override
    public double getAveragePerformance(int employeeId) {

        List<PerformanceHR> result =
                getEmployeePerformance(employeeId);

        if (result.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (PerformanceHR performance : result) {
            total += performance.getScore();
        }

        return total / result.size();
    }

    @Override
    public int getEvaluationCount() {
        return performances.size();
    }
}

