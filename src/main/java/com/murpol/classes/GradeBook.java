package com.murpol.classes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.RoundingMode.HALF_UP;

public class GradeBook {

    private final Map<String, Subject> subjects = new HashMap<>();

    public Map<String, Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(String subjectName, Subject subject) {
        subjects.putIfAbsent(subjectName, subject);
    }

    public void addGradeToSubject(String subjectName, int grade) {
        if (subjects.get(subjectName) == null) {
            throw new SubjectDoesntExistException(subjectName);
        }
        subjects.get(subjectName).addGrade(grade);
    }

    public double calculateAverageForAllSubjects() {
        double sum = 0;
        double denominator = 0;

        for (Subject subject : getSubjects().values()) {
            for (int grade : subject.getGrades()) {
                sum += grade;

            }
            denominator += subject.getGrades().size();
        }
        if (denominator <= 0) {
            throw new ArithmeticException("Denominator must hold a positive value");
        }
        return BigDecimal.valueOf(sum / denominator ).setScale(2, HALF_UP).doubleValue();
    }

    private static class SubjectDoesntExistException extends RuntimeException {
        public SubjectDoesntExistException(String subjectName) {
            super("There is no such subject [" + subjectName + "] in the grade book");
        }
    }
}
