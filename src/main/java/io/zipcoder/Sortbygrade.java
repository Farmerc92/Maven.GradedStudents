package io.zipcoder;

import java.util.Comparator;

public class Sortbygrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverageExamScore(), o2.getAverageExamScore());
    }
}
