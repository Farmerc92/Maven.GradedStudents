package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] student){
        students = student;
    }

    public Classroom(){
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0;
        int studentNumber = 0;
        for(Student s: students){
            sum += s.getAverageExamScore();
            studentNumber++;

        }
        return sum / studentNumber;
    }

    public void addStudent(Student student){
        Student[] newStudents = new Student[students.length+1];
        newStudents[newStudents.length-1] = student;
        students = newStudents;
    }

    public void removeStudent(String firstName, String lastName){
        int count = 0;
        for (Student s : students) {
            if(s.getFirstName() == firstName && s.getLastName() == lastName){
                break;
            }
            count++;
        }
        Student[] newStudents = new Student[students.length-1];
        int newStudentsIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (i == count){
            }
            else{
                newStudents[newStudentsIndex++] = students[i];
            }
        }
        students = newStudents;
    }

    public Student[] getStudentsByScore() {

        ArrayList<Student> array = new ArrayList<>();
        for (Student s : students) {
            array.add(s);
        }
        Collections.sort(array, new Sortbylastname());
        Collections.sort(array, new Sortbygrade());
        return array.toArray(new Student[students.length]);

    }

}
