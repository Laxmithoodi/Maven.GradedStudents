package io.zipcoder;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparator<Student> {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();
    private double examNumber;


    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for (Double d : examScores) {
            this.examScores.add(d);

        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() { return this.firstName + " " + this.lastName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {

        String result = "";
        System.out.println("Exam Scores: ");


        for (int i = 0; i < examScores.size(); i++) {

            result =  result +  "Exam " + (i+1) + " -> " + examScores.get(i) + "  \n";

        }
        return result;

//        int count = 1;
//        String strExamScores = "Exam Scores: \n Exam " + count;
//
//        for (double d : this.examScores) {
//            count++;
//
//            if (count <= examScores.size())
//                strExamScores = strExamScores + " -> " + d + "\n Exam " + count;
//            else
//                strExamScores = strExamScores + " -> " + d;
//        }
//        return strExamScores;
    }


    public Double addExamScore(double examscore) {

        this.examScores.add(examscore);

        return examScores.get(0);
    }

    public void setExamScore(int examNumber, double newScore) {

        this.examScores.set(examNumber - 1, new Double(newScore));

    }

    public Double getAverageExamScore() {
        Double sum = 0.0;

        for (int i = 0; i < examScores.size(); i++) {
            sum = sum + examScores.get(i);

        }


        return sum / examScores.size();
    }



    public double getTotalExamScore() {
        double totalScore = 0;
        for (Double indexScore : this.examScores) {
            totalScore += indexScore;
        }
        return totalScore;
    }

    public int getCountOfExams() {
        return examScores.size();
    }







//    public Double averageOfExams() {
//        Double[] exams = examScores.toArray(new Double[examScores.size()]);
//        Double sum = 0.00;
//        for (int i = 0; i < exams.length; i++) {
//            sum = sum + exams[i];
//        }
//        Double average = sum / exams.length;
//        return average;
//    }

    @Override
    public String toString() {

        return "Student Name " + firstName + " " + lastName + "\n" + "Average Score: " + getAverageExamScore().intValue()
                + "\n" + getExamScores();


    }


    public Integer getAerageExamScore() {
        int sum = 0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum/examScores.size();
    }


@Override
    public int compare(Student o1, Student o2) {
        return o2.getAverageExamScore().compareTo(o1.getAverageExamScore());
    }
}

