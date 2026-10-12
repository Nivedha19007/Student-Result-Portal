package com.wipro.resultportal.model;

import java.util.List;

public class StudentMarksRequest {

    private String studentId;
    private int semester;
    private List<Integer> marks;

    public StudentMarksRequest() {
    }

    public StudentMarksRequest(String studentId, int semester, List<Integer> marks) {
        this.studentId = studentId;
        this.semester = semester;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}