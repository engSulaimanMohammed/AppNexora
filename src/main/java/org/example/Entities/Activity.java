package org.example.Entities;
import java.time.LocalDateTime;

public class Activity {

    private int activityId;
    private int userId;
    private String action;
    private String description;
    private String category;
    private LocalDateTime timestamp;

    public Activity(int activityId,
                    int userId,
                    String action,
                    String description,
                    String category,
                    LocalDateTime timestamp) {

        this.activityId = activityId;
        this.userId = userId;
        this.action = action;
        this.description = description;
        this.category = category;
        this.timestamp = timestamp;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", userId=" + userId +
                ", action='" + action + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
