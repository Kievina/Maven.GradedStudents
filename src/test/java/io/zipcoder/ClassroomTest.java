package io.zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassroomTest {

    @Before
    public void setUp() {//throws Exception {
        /*student1 = new Student("Jimmy", "John", new Double[] {45.0, 50.0, 55.0});
        student2 = new Student("Tammy", "Tohn", new Double[] {60.0, 65.0});
        student3 = new Student("Tmy", "Thn", new Double[] {10.0, 65.0});
        student4 = new Student("Tmy", "Thn", new Double[] {100.0, 65.0});
    */
    }
    @After
    public void tearDown() {
    }

    @Test
    public void constructorNullTest() {
        // Given
        Student[] expected = new Student[30];

        // When
        Classroom classroom = new Classroom();
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorWithMaxNumStudentsTest() {
        // Given
        Student[] expected = new Student[3];

        // When
        Classroom classroom = new Classroom(3);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorWithStudentArrayTest() {
        // Given
        Student[] expected = new Student[3];

        // When
        Classroom classroom = new Classroom(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);
        double expected = 125;
        // When
        double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void addStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        System.out.println(classroom.students.length);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student newStudent = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(newStudent);
        System.out.println(classroom.students.length);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("==========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("==========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student newStudent = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(newStudent);
        int expected = 1; //classroom.students.length;

        // When
        classroom.removeStudent("Leon", "Hunter");

        // Then
        Assert.assertEquals(expected, classroom.students.length);
        Assert.assertNull(classroom.students[0]);
    }
    @Test
    public void getStudentsByScoreTest() {
        Double[] scores1 = new Double[] {45.0, 50.0, 55.0};
        Double[] scores2 = new Double[] {60.0, 65.0};
        Double[] scores3 = new Double[] {70.0, 70.0};
        Student student1 = new Student("Jimmy", "John", scores1 );
        Student student2 = new Student("Tammy", "Tohn", scores2 );
        Student student3 = new Student("Jack", "Tohn", scores3 );
        Student[] newStudents = {student1, student2, student3};
        Classroom classroom = new Classroom(newStudents);

        Student[] expected = {student3, student2, student1};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void getGradebookTest() {
       /* int n = 20;
        Student[] students = new Student[n];
        for (int i = 1; i<=n; i++) {
            students[i-1] = new Student("","",new Double[] {100.0,5.0*i});
        }
        Classroom classroom = new Classroom(students);*/
        Double[] scores1 = new Double[] {45.0, 50.0, 55.0};
        Double[] scores2 = new Double[] {60.0, 65.0};
        Double[] scores3 = new Double[] {70.0, 70.0};
        Double[] scores4 = new Double[] {95.0, 90.0, 95.0};
        Double[] scores5 = new Double[] {80.0, 85.0};
        Student student1 = new Student("Jimmy", "John", scores1 );
        Student student2 = new Student("Tammy", "Tohn", scores2 );
        Student student3 = new Student("Jack", "Tohn", scores3 );
        Student student4 = new Student("Rhett", "Ale", scores4 );
        Student student5 = new Student("Amy", "Roberts", scores5 );
        Student[] newStudents = {student1, student2, student3, student4, student5};
        Classroom classroom = new Classroom(newStudents);

        Map<Student,String> gradebook = classroom.getGradebook();

        Assert.assertEquals(gradebook.get(student1),"F");
        Assert.assertEquals(gradebook.get(student2),"D");
        Assert.assertEquals(gradebook.get(student3),"C");
        Assert.assertEquals(gradebook.get(student4),"A");
        Assert.assertEquals(gradebook.get(student5),"B");

    }

}
