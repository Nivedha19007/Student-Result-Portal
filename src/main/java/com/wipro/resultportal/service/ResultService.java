package com.wipro.resultportal.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wipro.resultportal.exception.DuplicateResultException;
import com.wipro.resultportal.exception.InvalidMarkException;
import com.wipro.resultportal.model.ResultRecord;
import com.wipro.resultportal.model.StudentMarksRequest;
import com.wipro.resultportal.strategy.CgpaGradingStrategy;
import com.wipro.resultportal.strategy.GradingStrategy;
import com.wipro.resultportal.strategy.PercentageGradingStrategy;

@Service
public class ResultService {

    private Map<String, List<ResultRecord>> resultMap = new HashMap<>();

    public ResultRecord submitResult(StudentMarksRequest req, String gradingType) {

        // Validate marks
        for (Integer mark : req.getMarks()) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Marks should be between 0 and 100");
            }
        }

        // Check duplicate result
        List<ResultRecord> records =
                resultMap.getOrDefault(req.getStudentId(), new ArrayList<>());

        for (ResultRecord record : records) {
            if (record.getSemester() == req.getSemester()) {
                throw new DuplicateResultException(
                        "Result already exists for this student and semester");
            }
        }

        // Select grading strategy
        GradingStrategy strategy;

        if ("CGPA".equalsIgnoreCase(gradingType)) {
            strategy = new CgpaGradingStrategy();
        } else {
            strategy = new PercentageGradingStrategy();
        }

        String grade = strategy.calculateGrade(req.getMarks());

        // Calculate total
        int total = req.getMarks().stream()
                .mapToInt(Integer::intValue)
                .sum();

        // Calculate average
        double average = (double) total / req.getMarks().size();

        // Create result object
        ResultRecord result = new ResultRecord();

        result.setStudentId(req.getStudentId());
        result.setSemester(req.getSemester());
        result.setTotal(total);
        result.setAverage(average);
        result.setGrade(grade);

        // Store result
        records.add(result);
        resultMap.put(req.getStudentId(), records);

        return result;
    }

    public List<ResultRecord> getResultsByStudent(String studentId) {

        List<ResultRecord> records =
                resultMap.getOrDefault(studentId, new ArrayList<>());

        records.sort(Comparator.comparingInt(ResultRecord::getSemester));

        return records;
    }
}
