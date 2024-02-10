package com.example.birzeitstudyplanner;

public class UpcomingClassModel {
    private String className;
    private String classLocation;
    private String timeRemaining;
    private int timeRemainingInMinutes;
    public UpcomingClassModel(String className, String classLocation, String timeRemaining) {
        this.className = className;
        this.classLocation = classLocation;
        this.timeRemaining = timeRemaining;
    }

    public String getClassName() {
        return className;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public void setTimeRemaining(String timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getTimeRemainingInMinutes() {
        return timeRemainingInMinutes;
    }

    public  void setTimeRemainingInMinutes(int timeRemainingInMinute){
        this.timeRemainingInMinutes = timeRemainingInMinute;
    }
}
