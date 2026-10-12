package com.wipro.resultportal.strategy;

import java.util.List;

public class PercentageGradingStrategy implements GradingStrategy {

    @Override
    public String calculateGrade(List<Integer> marks) {

        int total = marks.stream().mapToInt(Integer::intValue).sum();
        double percentage = (double) total / marks.size();

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
