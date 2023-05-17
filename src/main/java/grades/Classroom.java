package grades;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Classroom {


    private Student[] students;


    private int maxNumberOfStudents;


    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];

    }


    public Classroom(Student[] students) {
        this.students = students;
        this.maxNumberOfStudents = students.length;
    }


    public Classroom() {
        this.students = new Student[30];

    }

    public Student[] getStudents() {
        return this.students;
    }


    public double getAverageExamScore() {
        double totalScore = 0;
        int numExams = 0;
        for (Student student : students) {
     double studentAvg = student.getAverageExamScore();
            if (Double.isNaN(studentAvg)) {
                continue;
            }
            totalScore += studentAvg;
            numExams++;
        }
        if (numExams == 0) {
            return 0;
        }
        return totalScore / numExams;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
 if (student != null && student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                students[i] = null;

                for (int j = i; j < students.length - 1; j++) {
                  students[j] = students[j + 1];
                }
        students[students.length - 1] = null;
                break;
   }
        }
    }

    public Student[] getStudentsByScore() {


        Student[] sortedStudents = Arrays.copyOf(students, students.length);


        Arrays.sort(sortedStudents, (s1, s2) -> {


            if (s1 == null && s2 == null) {
                return 0;


            } else if (s1 == null) {


                return 1;
            } else if (s2 == null) {
                return -1;
            } else {
                int compareScore = Double.compare(s1.getAverageExamScore(), s2.getAverageExamScore());
                if (compareScore == 0) {

          int lexiComparison = s1.getLastName().compareTo(s2.getLastName());
                    if (lexiComparison == 0) {
                        return s1.getFirstName().compareTo(s2.getFirstName());
                    }
                    return lexiComparison;
                }
                return compareScore;
            }

        });
        return sortedStudents;
    }

    public Map<Student, Character> getGradeBook() {


        Map<Student, Character> gradeBook = new HashMap<>();


        int totalStudents = 0;


        for (Student student : students) {


            if (student != null) {


                totalStudents++;
            }



        }
        int upper10thPercentile = (int) Math.ceil(totalStudents * 0.1);

      int upper11thPercentile = (int) Math.ceil(totalStudents * 0.11);

   int upper29thPercentile = (int) Math.ceil(totalStudents * 0.29);

       int upper30thPercentile = (int) Math.ceil(totalStudents * 0.3);

    int upper50thPercentile = (int) Math.ceil(totalStudents * 0.5);

        int lower11thPercentile = (int) Math.ceil(totalStudents * 0.89);

        Student[] sortStudent = getStudentsByScore();


        for (int grade = 0; grade < totalStudents; grade++) {


     Student student = sortStudent[grade];


            double averageScr = student.getAverageExamScore();


   if (grade < upper10thPercentile) {

                gradeBook.put(student, 'A');

         } else if (grade < upper30thPercentile) {

                gradeBook.put(student, 'B');

            } else if (grade < upper50thPercentile) {

                gradeBook.put(student, 'C');

            } else if (grade < lower11thPercentile) {

                gradeBook.put(student, 'D');

            } else {

                gradeBook.put(student, 'F');

            }
        }
        return gradeBook;


    }


}




