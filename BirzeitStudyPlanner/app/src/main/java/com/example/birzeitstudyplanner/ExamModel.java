package com.example.birzeitstudyplanner;

public class ExamModel {
    private String CourseName;
    private String ExamDate;
    private String Mark;
    private int Status;

    public ExamModel(String courseName,String examDate,String mark,int status){
        this.ExamDate = examDate;
        this.Mark = mark;
        this.CourseName = courseName;
        this.Status = status;
    }
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getExamDate() {
        return ExamDate;
    }

    public String getMark() {
        return Mark;
    }

    public void setExamDate(String examDate) {
        ExamDate = examDate;
    }

    public void setMark(String mark) {
        Mark = mark;
    }
}
