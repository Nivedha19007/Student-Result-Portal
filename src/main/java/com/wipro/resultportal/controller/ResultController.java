package com.wipro.resultportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.resultportal.model.ResultRecord;
import com.wipro.resultportal.model.StudentMarksRequest;
import com.wipro.resultportal.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResultRecord submitResult(
            @RequestBody StudentMarksRequest request,
            @RequestParam String gradingType) {

        return resultService.submitResult(request, gradingType);
    }

    @GetMapping("/{studentId}")
    public List<ResultRecord> getResults(@PathVariable String studentId) {
        return resultService.getResultsByStudent(studentId);
    }
}