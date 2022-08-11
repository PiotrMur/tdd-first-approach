package com.murpol.classes;

import java.util.HashMap;
import java.util.Map;

public class GradeBook {

    private final Map<String, Subject> subjects = new HashMap<>();

    public Map<String, Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(String name, Subject subject) {
        getSubjects().put(name, subject);
    }

    public void addGradeToSubject(String name, int grade) {
        getSubjects().get(name).addGrade(grade);
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
        return Math.round(sum/denominator*100.0)/100.0;
    }
}
