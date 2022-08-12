package com.murpol.classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;

public class Subject {

    private final String name;
    private final List<Integer> grades = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        if (!(grade >= 1 && grade <= 5)) {
            throw new IllegalArgumentException("Grades must belong to the range '1-5'");
        }
        grades.add(grade);
    }

    public double calculateSubjectAverage() {
        if (grades.isEmpty()){
            return 0d;
        }

        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return BigDecimal.valueOf(sum / grades.size()).setScale(2, HALF_UP).doubleValue();
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

    @Override
    public String toString() {
        return name + " = " + getGrades();
    }
}
