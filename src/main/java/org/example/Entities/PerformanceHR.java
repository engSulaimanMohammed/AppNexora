package org.example.Entities;

import java.time.LocalDate;

public class PerformanceHR {

    private int performanceId;
    private int employeeId;

    private String period;
    private double score;
    private String rating;
    private String comments;

    private LocalDate evaluationDate;

    public PerformanceHR(
            int performanceId,
            int employeeId,
            String period,
            double score,
            String rating,
            String comments,
            LocalDate evaluationDate) {

        this.performanceId = performanceId;
        this.employeeId = employeeId;
        this.period = period;
        this.score = score;
        this.rating = calculateRating(score);
        this.comments = comments;
        this.evaluationDate = evaluationDate;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPeriod() {
        return period;
    }

    public double getScore() {
        return score;
    }

    public String getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setScore(double score) {
        this.score = score;
        this.rating = calculateRating(score);
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public static String calculateRating(double score) {

        if (score >= 90) {
            return "Excellent";
        }

        if (score >= 80) {
            return "Very Good";
        }

        if (score >= 70) {
            return "Good";
        }

        if (score >= 60) {
            return "Needs Improvement";
        }

        return "Poor";
    }
}
