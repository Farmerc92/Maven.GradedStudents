package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

public class ClassroomTest {
    private static final Logger LOGGER = Logger.getLogger(ClassroomTest.class.getName());
    @Test
    public void classroomConstructorTest1(){
        Student s1 = new Student();
        Student s2 = new Student();
        Student[] array = new Student[2];
        array[0] = s1;
        array[1] = s2;
        Classroom cr = new Classroom(array);

        Assert.assertEquals(cr.getStudents()[0], array[0]);
        Assert.assertEquals(cr.getStudents()[1], array[1]);
    }

    @Test
    public void classroomConstructorTest2(){
        Student[] array = new Student[30];
        int expected = array.length;
        Classroom cr = new Classroom(30);
        int actual = cr.getStudents().length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void classroomConstructorTest3(){
        Student[] array = new Student[30];
        int expected = array.length;
        Classroom cr1 = new Classroom();
        int actual = cr1.getStudents().length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoresTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        LOGGER.info("\n"+ output);
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 0;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        LOGGER.info(preEnrollmentAsString);
        LOGGER.info(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest(){
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores1 = { 100.0, 150.0, 250.0, 0.0 };
        Student student1 = new Student("Bob", "Dole", examScores);

        Student[] studentArray = new Student[2];
        studentArray[0] = student;
        studentArray[1] = student1;

        Classroom classroom1 = new Classroom(studentArray);


        Student[] preRemove = classroom1.getStudents();
        classroom1.removeStudent("Leon", "Hunter");
        Student[] afterRemove = classroom1.getStudents();

        String preRemoveAsString = Arrays.toString(preRemove);
        String postRemoveAsString = Arrays.toString(afterRemove);

        LOGGER.info(preRemoveAsString);
        LOGGER.info(postRemoveAsString);
    }

    @Test
    public void getStudentsbyScore(){
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores1 = { 90.0, 150.0, 250.0, 0.0 };
        Student student1 = new Student("Bob", "Dole", examScores1);

        Student student2 = new Student("Steve", "Jackson", examScores1);

        Double[] examScores3 = { 1000.0, 150.0, 250.0, 0.0 };
        Student student3 = new Student("John", "Guy", examScores3);

        Student[] studentArray = new Student[4];
        studentArray[0] = student;
        studentArray[1] = student1;
        studentArray[2] = student2;
        studentArray[3] = student3;

        Classroom classroom2 = new Classroom(studentArray);

        Student[] byScore = classroom2.getStudentsByScore();


        Assert.assertEquals(student3, byScore[0]);
        Assert.assertEquals(student, byScore[1]);
        Assert.assertEquals(student1, byScore[2]);
        Assert.assertEquals(student2, byScore[3]);
    }

    @Test
    public void getGradeBookTest(){
        Double[] examScores = { 100.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores1 = { 89.0 };
        Student student1 = new Student("Bob", "Dole", examScores1);

        Student student2 = new Student("Steve", "Jackson", examScores1);

        Double[] examScores3 = { 69.0 };
        Student student3 = new Student("John", "Guy", examScores3);

        Double[] examScores4 = { 49.0 };
        Student student4 = new Student("Dexter", "Lab", examScores4);

        Double[] examScores5 = { 5.0 };
        Student student5 = new Student("Jimmy", "Neutron", examScores5);

        Student[] studentArray = new Student[6];
        studentArray[0] = student;
        studentArray[1] = student1;
        studentArray[2] = student2;
        studentArray[3] = student3;
        studentArray[4] = student4;
        studentArray[5] = student5;

        Classroom classGrade = new Classroom(studentArray);
        HashMap<Character, ArrayList<Student>> actual = new HashMap<>();
        HashMap<Character, ArrayList<Student>> expected = classGrade.getGradeBook();
        ArrayList<Student> studentsTestA = new ArrayList<>();
        ArrayList<Student> studentsTestB = new ArrayList<>();
        ArrayList<Student> studentsTestC = new ArrayList<>();
        ArrayList<Student> studentsTestD = new ArrayList<>();
        ArrayList<Student> studentsTestF = new ArrayList<>();
        studentsTestA.add(student);
        studentsTestB.add(student1);
        studentsTestB.add(student2);
        studentsTestC.add(student3);
        studentsTestD.add(student4);
        studentsTestF.add(student5);

        actual.put('A', studentsTestA);
        actual.put('B', studentsTestB);
        actual.put('C', studentsTestC);
        actual.put('D', studentsTestD);
        actual.put('F', studentsTestF);

        Assert.assertEquals(expected.get('A').get(0), actual.get('A').get(0));
        Assert.assertEquals(expected.get('B').get(0), actual.get('B').get(0));
        Assert.assertEquals(expected.get('B').get(1), actual.get('B').get(1));
        Assert.assertEquals(expected.get('C').get(0), actual.get('C').get(0));
        Assert.assertEquals(expected.get('D').get(0), actual.get('D').get(0));
        Assert.assertEquals(expected.get('F').get(0), actual.get('F').get(0));
    }
}
