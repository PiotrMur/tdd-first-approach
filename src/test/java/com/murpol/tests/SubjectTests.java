package com.murpol.tests;

import com.murpol.classes.Subject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SubjectTests {


    @Test
    void addingGradeToSubject() {
        //given
        String name = "Polski";
        var subject = new Subject(name);
        //when
        subject.addGrade(4);

        List<Integer> grades = subject.getGrades();
        assertThat(grades).isNotEmpty();
    }

    @Test
    void gettingAllGrades() {
        String name = "Polski";
        var subject = new Subject(name);
        subject.addGrade(4);
        subject.addGrade(5);

        List<Integer> grades = subject.getGrades();

        assertThat(grades).containsExactly(4,5);
    }

    @Test
    void calculatingSubjectsGradesAverage() {
        var subject = new Subject("Polski");
        subject.addGrade(4);
        subject.addGrade(2);

        double average = subject.calculateSubjectAverage();

        assertThat(average).isEqualTo(3);
    }
}
