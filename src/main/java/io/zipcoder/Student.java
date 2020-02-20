package io.zipcoder;

import java.util.ArrayList;
import java.util.Comparator;

public class Student{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>();
        for (Double d : testScores) {
            examScores.add(d);
        }
    }
    public Student(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        String results = "Exam Scores: \n";
        int count = 1;
        for (Double d : examScores) {
            String examFormat = String.format("%1.0f", d);
            results += "    Exam " + count + " -> "+ examFormat + "\n";
            count++;
        }
        return results;
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0;
        for(double d : examScores){
            sum += d;
        }
        return (int) sum / examScores.size();
    }
    @Override
    public String toString(){
        String output = "Student Name: "+ this.firstName + " " + this.lastName+"\n";
        output += "> Average Score: "+ this.getAverageExamScore() + "\n";
        output += "> "+ this.getExamScores();
        return output;
    }
}
