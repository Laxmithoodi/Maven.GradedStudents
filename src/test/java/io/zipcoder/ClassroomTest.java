package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {




    @Test
    public void testGetAverageExamScore(){

        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
       Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

@Test
    public void testAddStudent(){



    // : Given
    int maxNumberOfStudents = 1;
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

    System.out.println("===========================");
    System.out.println(preEnrollmentAsString);
    System.out.println("===========================");
    System.out.println(postEnrollmentAsString);
}

@Test
    public void testRemoveStudent(){


    // : Given
    int maxNumberOfStudents = 1;
    Classroom classroom = new Classroom(maxNumberOfStudents);
    Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
    Student student1 = new Student("Leon", "Hunter", examScores);
    Student student2 = new Student("Laxmi", "thoodi", examScores);

    // When
    classroom.addStudent(student1);
    classroom.addStudent(student2);
    Student[] preremoval = classroom.getStudents();

    classroom.removeStudent("Leon", "Hunter");
    Student[] postremoval = classroom.getStudents();

    // Then

    String preEnrollmentAsString = Arrays.toString(preremoval);
    String postEnrollmentAsString = Arrays.toString(postremoval);

    System.out.println("===========================");
    System.out.println(preEnrollmentAsString);
    System.out.println("===========================");
    System.out.println(postEnrollmentAsString);

}

    @Test
    public void getStudentsByScoreTest_SameAverageScore() {
        Double[] examScores1 = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 200.0, 170.0 };
        Double[] examScores3 = { 50.0, 60.0 };
        Student student1 = new Student("student", "one", examScores1);
        Student student2 = new Student("student", "two", examScores2);
        Student student3 = new Student("student", "three", examScores3);
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);

        student1.addExamScore(100);
        student1.addExamScore(100);
        student2.addExamScore(100);
        student2.addExamScore(100);
        student3.addExamScore(50);
        student3.addExamScore(90);

        Student[] expected = {student2, student1, student3};
        Student[] actual = testClassroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
        System.out.println(actual);

    }

    @Test
    public void getGradeBookTest() {
        Double[] examScores1 = {100.0, 150.0, 250.0, 0.0};
        Double[] examScores2 = {200.0, 170.0};
        Double[] examScores3 = {50.0, 60.0};
        Student student1 = new Student("student", "one", examScores1);
        Student student2 = new Student("student", "two", examScores2);
        Student student3 = new Student("student", "three", examScores3);
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);
        student1.addExamScore(100);
        student1.addExamScore(100);
        student2.addExamScore(100);
        student2.addExamScore(100);
        student3.addExamScore(50);
        student3.addExamScore(90);

        List<Student> gradeA = new ArrayList<>();
        gradeA.add(student1);

        List<Student> gradeB = new ArrayList<>();
        gradeB.add(student2);
        gradeB.add(student3);


        HashMap<String, List<Student>> expectedGradeBook = new HashMap<>();
        expectedGradeBook.put("A", gradeA);
        expectedGradeBook.put("B", gradeB);


        HashMap<String, List<Student>> actualGradeBook = testClassroom.getGradeBook();



        Assert.assertEquals(expectedGradeBook, actualGradeBook);


    }

}






