# Student Result Portal
A REST API application developed using Java and Spring Boot to manage student semester results and calculate grades using different grading strategies.

# Features
- Submit student marks and calculate grades.
- Support Percentage and CGPA grading strategies.
- Validate marks between 0 and 100.
- Handle invalid marks using custom exceptions.
- Prevent duplicate results for the same student and semester.
- Retrieve student results sorted by semester.
- Global exception handling with appropriate HTTP status codes.

# Technologies Used
- Java
- Spring Boot
- Spring Web
- Maven
- REST API
- Git and GitHub

# Design Patterns and Concepts
- Strategy Design Pattern: Uses GradingStrategy , PercentageGradingStrategy , and CgpaGradingStrategy.
- Exception Handling: Uses custom exceptions and a global exception handler.
- Java Streams: Used for checking duplicate results and sorting results by semester.

# API Endpoints

## Submit Student Results
`POST /results?gradingType=PERCENTAGE`
Example JSON request:
```json
{
  "studentId": "STU001",
  "semester": 1,
  "marks": [95, 88, 92, 90, 89]
}
```
For CGPA grading, use:
`POST /results?gradingType=CGPA`

## Retrieve Student Results
`GET /results/STU001`
Returns the student's results sorted by semester.

# HTTP Status Codes
- 200 OK : Results retrieved successfully
- 201 Created : Result submitted successfully
- 400 Bad Request :  Invalid marks or grading type
- 409 Conflict : Duplicate result submission

# How to Run
Make sure Java is installed, then run the following command in the project folder on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```
The application runs at `http://localhost:8080`.

# Data Storage
Results are stored in memory and are not retained after the application stops.

# Purpose
Developed as a Java Spring Boot project to demonstrate REST APIs, the Strategy Design Pattern, and exception handling.
