package com.murpol;

import com.murpol.classes.GradeBook;
import com.murpol.classes.Subject;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        var gradebook = new GradeBook();
        var polski = new Subject("Polski");
        var angielski = new Subject("Angielski");
        var polskiRep = new Subject("Polski");

        polski.addGrade(5);
        polski.addGrade(4);
        polski.addGrade(4);
        polski.addGrade(2);

        angielski.addGrade(5);
        angielski.addGrade(2);
        angielski.addGrade(4);
        angielski.addGrade(5);
        angielski.addGrade(1);

        System.out.println(polski.calculateSubjectAverage());
        System.out.println(angielski.calculateSubjectAverage());

        gradebook.addSubject("Polski", polski);
        gradebook.addSubject("Angielski", angielski);
        gradebook.addSubject("Polski", polskiRep);

        gradebook.getSubjects().forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println(gradebook.calculateAverageForAllSubjects());
    }
}
