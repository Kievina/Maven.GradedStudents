package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getTestScores() {
        return examScores;
    }

    public int getNumberOfExamsTaken() {
        return this.getTestScores().size();
    }

    public String getExamScores() {
        String results = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            results = results + String.format(" Exam %d -> %d\n", i + 1, (int)Math.rint(examScores.get(i)));
        }
        return results;
    }

    public ArrayList<Double> addExamScore(double examScore) {
        this.examScores.add(examScore);
        return examScores;
    }

    public void setExamScore(int examNumber, double newScore) {
        this.examScores.set(examNumber - 1, newScore);
    }

    public Double getAverageExamScore() {
        double sum = 0;
        for (int i = 0; i < examScores.size(); i++) {
            sum = sum + examScores.get(i);
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + ' ' + lastName + '\n' +
                "Average Score: " + this.getAverageExamScore() + '\n' +
                this.getExamScores();
    }

}

