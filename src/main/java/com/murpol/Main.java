package com.murpol;

import com.murpol.classes.GradeBook;
import com.murpol.classes.Subject;

public class Main {

    public static void main(String[] args) {

        var gradebook = new GradeBook();
        var polski = new Subject("Polski");
        var angielski = new Subject("Angielski");

        polski.addGrade(5);
        polski.addGrade(3);

        angielski.addGrade(5);
        angielski.addGrade(2);

        System.out.println(polski.calculateSubjectAverage());
        System.out.println(angielski.calculateSubjectAverage());

        gradebook.addSubject("Polski", polski);
        gradebook.addSubject("Angielski", angielski);

        System.out.println(gradebook.calculateAverageForAllSubjects());
    }
}
