package com.example.birzeitstudyplanner;

public class CourseModel {
    private String courseName;
    private String instructorName;
    private String startTime;
    private String endTime;
    private String daysOfWeek;

    public CourseModel(String courseName,String instructorName,String startTime,String endTime,String daysOfWeek){
        this.courseName=courseName;
        this.endTime = endTime;
        this.daysOfWeek = daysOfWeek;
        this.startTime = startTime;
        this.instructorName = instructorName;
    }

    public CourseModel(){

    }

    public String getCourseName() {
        return courseName;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


}
