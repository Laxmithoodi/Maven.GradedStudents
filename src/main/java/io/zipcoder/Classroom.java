package io.zipcoder;


import java.util.*;

public class Classroom {




    private Student[] students;
    private int maxNumberOfStudent;


    public Classroom(int maxNumberOfStudent) {
        this.students = new Student[0]; //if intalized for number of students preenrollment gets null

    }


    public Classroom(Student[] students) {
        this.students = students;


    }


    public Classroom() {
        this(30);
    }


    public Student[] getStudents() {
        this.students = students;

        return students;
    }


    public Double getAverageExamScore() {
        Double sum = 0.0;
        Double avgscore = 0.0;

        for (Student s : students) {
            sum = sum + s.getAverageExamScore();

            avgscore = sum / students.length;
        }

        return avgscore;
    }


    public void addStudent(Student student) {


        Student[] newStudentAddedarray = Arrays.copyOf(students, students.length + 1);
        newStudentAddedarray[newStudentAddedarray.length - 1] = student;
        students = newStudentAddedarray;

    }


    public void removeStudent(String firstName, String lastName) {

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getFullName().equals(firstName + " " + lastName)) {
                this.students[i] = null;
            }

        }
    }


    public Student[] getStudentsByScore() {
//        Arrays.sort(students);
//        return students;
        List<Student> studentsByScore = Arrays.asList(students);

        Collections.sort(studentsByScore, (s1, s2) -> {

            if (s1.getAverageExamScore() > s2.getAverageExamScore()) {
                return -1;
            } else if (s1.getAverageExamScore() < s2.getAverageExamScore()) {
                return 1;
            } else {
                return s1.getFullName().compareTo(s2.getFullName());
            }
        });

        Student[] result = new Student[studentsByScore.size()];
        result = studentsByScore.toArray(result);

        return result;
    }




    public int percentile(Student[] sortedStudents, double percentile) {
        int index = (int) Math.ceil((percentile / (double) 100) * (double) sortedStudents.length);

        return index;
    }





    public HashMap<String, List<Student>> getGradeBook() {
        Student[] studentScores = this.getStudentsByScore();

        int gradeA = this.percentile(studentScores, 10);
        int gradeB = this.percentile(studentScores, 29);
        HashMap<String, List<Student>> gradeBook = new HashMap<>();

        List<Student> aStudents = Arrays.asList(Arrays.copyOfRange(studentScores, 0, gradeA));
        gradeBook.put("A", aStudents);

        List<Student> bStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeA, gradeB));
        gradeBook.put("B", bStudents);

        return gradeBook;
    }



}














//        int gradeC = this.percentile(studentScores, 50);
//        int gradeD = this.percentile(studentScores, 89);
//        int gradeF = this.percentile(studentScores, 100);

//        List<Student> cStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeB, gradeC));
//        gradeBook.put("C", cStudents);
//
//        List<Student> dStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeC, gradeD));
//        gradeBook.put("D", dStudents);
//
//        List<Student> fStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeD, gradeF));
//        gradeBook.put("F", fStudents);

















    //
//    public Student[] getStudentsByScore(ArrayList<Student> studentsList, Double[] s1) {
//
//
//        ArrayList<Student> studentArray = new ArrayList<>();
//
//        for (Student s : studentArray) {
//           if(s.getExamScores().equals(s1)){
//               studentArray.add(s);
//           }
//
//
//           }
//
//
//        return studentArray.toArray(students);
//    }
//}

//  ArrayList<Student> newStudent = new ArrayList<>();
//        for (Student stud:students){
//            //check if student is not null
//            if(stud != null) {
//                newStudent.add(stud);
//            }
//        }
//        newStudent.add(student);
//
//        this.students = newStudent.toArray(new Student[students.length+1]);













