package io.zipcoder;

import java.util.*;

public class Classroom {

    Student[] students;

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double total = 0;
        for (int i = 0; i < students.length; i++) {
            total = total + students[i].getAverageExamScore();
        }
        return total / students.length;
    }

    public void addStudent(Student student) {

        //int newLength = students.length + 1;
        ArrayList<Student> newList = new ArrayList(Arrays.asList(students));
        if (newList.contains(null)) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    newList.set(i, student);
                }
            }
        } else {
            newList.add(student);
        }
        students = newList.toArray(new Student[newList.size()]);
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> newList = new ArrayList(Arrays.asList(students));
        int studentsLength = students.length;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName() == firstName && students[i].getLastName() == lastName) {
                newList.remove(i);
            }
        }
        students = newList.toArray(new Student[studentsLength]);
    }

    public Student[] getStudentsByScore() {

        //Arrays.sort(students, Collections.reverseOrder());
        ArrayList<Student> newStudentList = new ArrayList<Student> (Arrays.asList(students));
        Collections.sort(newStudentList, new SortByLastName());
        Collections.sort(newStudentList, new SortByAverageScore());
        return newStudentList.toArray(new Student[students.length]);
    }

    public Map<Student, String> getGradebook() {
        Map<Student, String> gradebook = new HashMap<>();
        String grade = "";
        for (Student student : students) {
            if (student.getAverageExamScore() >= 90)
                grade = "A";
            else if (student.getAverageExamScore() >= 80)
                grade = "B";
            else if (student.getAverageExamScore() >= 70)
                grade = "C";
            else if (student.getAverageExamScore() >= 60)
                grade = "D";
            else
                grade = "F";
            gradebook.put(student, grade);
        }
        return gradebook;
    }
}