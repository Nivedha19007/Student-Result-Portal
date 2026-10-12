package com.wipro.resultportal.model;

public class ResultRecord {

    private String studentId;
    private String grade;
    private int semester;
    private int total;
    private double average;

    public ResultRecord() {
    }

    public ResultRecord(String studentId, String grade, int semester, int total, double average) {
        this.studentId = studentId;
        this.grade = grade;
        this.semester = semester;
        this.total = total;
        this.average = average;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
