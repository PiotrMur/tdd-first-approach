package com.murpol.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {

    private final String name;
    private final List<Integer> grades = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        if (grade >= 1 && grade <= 5) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Grades must belong to the range '1-5'");
        }
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }


    public double calculateSubjectAverage() {
        int sum = 0;
        for (int grade : getGrades()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grades);
    }
}
