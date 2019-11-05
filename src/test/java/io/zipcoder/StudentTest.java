package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class StudentTest {

    @Test
    public void constructorTest() {
        // Given
        String expectedFirstName = "Leon";
        String expectedLastName = "Hunter";
        Double[] expectedTestScores = {100.0, 95.0, 123.0, 96.0};

        // When
        Student student = new Student(expectedFirstName, expectedLastName, expectedTestScores);
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        ArrayList<Double> actualTestScores = student.getTestScores();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(Arrays.asList(expectedTestScores), actualTestScores);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        int expected = examScores.length;

        // When
        int actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\n Exam 1 -> 100\n Exam 2 -> 95\n Exam 3 -> 123\n Exam 4 -> 96\n";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Double[] expected = {100.0, 95.0, 123.0, 96.0, 76.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        ArrayList<Double> actual = student.addExamScore(76.0);

        // Then
        Assert.assertEquals(Arrays.asList(expected), actual);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String expected = "Exam Scores:\n Exam 1 -> 150\n";

        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Double expected = 103.5;

        // When
        Student student = new Student(firstName, lastName, examScores);
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0.05);
    }

    @Test //TODO
    public void toString1Test() {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Student Name: " + firstName + ' ' + lastName + '\n' +
                "Average Score: " + student.getAverageExamScore() + '\n' +
                student.getExamScores();

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}