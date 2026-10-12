package com.wipro.resultportal.strategy;

import java.util.List;

public class CgpaGradingStrategy implements GradingStrategy {

    @Override
    public String calculateGrade(List<Integer> marks) {

        int total = marks.stream().mapToInt(Integer::intValue).sum();
        double average = (double) total / marks.size();

        double cgpa = average / 10;

        if (cgpa >= 9) {
            return "A";
        } else if (cgpa >= 8) {
            return "B";
        } else if (cgpa >= 7) {
            return "C";
        } else if (cgpa >= 6) {
            return "D";
        } else {
            return "F";
        }
    }
}
