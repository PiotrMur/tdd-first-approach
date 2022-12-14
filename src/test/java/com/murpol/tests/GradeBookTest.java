package com.murpol.tests;

import com.murpol.classes.GradeBook;
import com.murpol.classes.Subject;
import org.assertj.core.api.Assert;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GradeBookTest {

    GradeBook gradeBook = new GradeBook();


    @Test
    void addingSubjectToGradeBook() {
        String name = "Polski";

        var subject = new Subject(name);

        gradeBook.addSubject(name, subject);
        var subjects = gradeBook.getSubjects();

        assertThat(subjects).containsKey(name);
    }

    @Test
    void addingGradeToSubject() {
        int grade = 3;
        String name = "Polski";
        var subject = new Subject(name);

        gradeBook.addSubject(name, subject);
        gradeBook.addGradeToSubject(name, grade);

        assertThat(gradeBook.getSubjects().get(name).getGrades()).contains(grade);

    }

    @Test
    void calculatingAverageForAllSubjects() {
        String name1 = "Polski";
        String name2 = "Angielski";
        String name3 = "Matematyka";

        var subject1 = new Subject(name1);
        var subject2 = new Subject(name2);
        var subject3 = new Subject(name3);

        subject1.addGrade(1);
        subject1.addGrade(3);

        subject2.addGrade(5);
        subject2.addGrade(3);

        subject3.addGrade(3);
        subject3.addGrade(2);

        gradeBook.addSubject("Polski", subject1);
        gradeBook.addSubject("Angielski", subject2);
        gradeBook.addSubject("Matematyka", subject3);

        double average = gradeBook.calculateAverageForAllSubjects();

        assertThat(average).isEqualTo(2.83);
    }


    @Test
    void preventingAddingAlreadyExisitngElement(){
        String name1 = "Polski";
        String name2 = "Polski";

        var subject1 = new Subject(name1);
        var subject2 = new Subject(name2);

        gradeBook.addSubject("Polski", subject1);
        gradeBook.addSubject("Polski", subject2);

        assertThat(gradeBook.getSubjects()).containsExactly(MapEntry.entry("Polski", subject1));
    }
}
