package com.murpol.classes;

import java.util.HashMap;
import java.util.Map;

public class GradeBook {

    private final Map<String, Subject> subjects = new HashMap<>();

    public Map<String, Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(String name, Subject subject) {
        if (!(getSubjects().containsKey(name))) {
            getSubjects().put(name, subject);
        } else {
            throw new IllegalArgumentException("An element with the key: '" + name + "' is already in the grade book");
        }

    }

    public void addGradeToSubject(String name, int grade) {
        if (getSubjects().get(name) != null) {
            getSubjects().get(name).addGrade(grade);
        } else {
            throw new NullPointerException("There is no such subject in the grade book");
        }
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
        if(denominator<=0){
            throw new ArithmeticException("Denominator must hold a positive value");
        }
        return Math.round(sum / denominator * 100.0) / 100.0;
    }
}
