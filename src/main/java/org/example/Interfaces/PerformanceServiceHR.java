package org.example.Interfaces;
import org.example.Entities.PerformanceHR;
import java.util.List;
public interface PerformanceServiceHR {

    void addPerformance(PerformanceHR performanceHR);

    List<PerformanceHR> getAllPerformance();

    List<PerformanceHR> getEmployeePerformance(int employeeId);

    double getAveragePerformance(int employeeId);

    int getEvaluationCount();
}
