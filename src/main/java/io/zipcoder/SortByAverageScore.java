package io.zipcoder;

import java.util.Comparator;

public class SortByAverageScore implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student2.getAverageExamScore().compareTo(student1.getAverageExamScore());
    }
}
