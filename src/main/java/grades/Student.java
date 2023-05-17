package grades;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;

    private String lastName;

    private ArrayList<Double> examScores = new ArrayList<>();



    public Student (String firstName, String lastName, Double[] testScores){

        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));


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

    public ArrayList<Double> getExamScores() {
        return examScores;
    }
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String printExamScores() {


        String output = "Exam Scores:";


        for (int i = 0; i < examScores.size(); i++) {


            output += "Exam " + (i+1) + " -> " + examScores.get(i) + "";


        }
        return output;

    }


    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }


    public double getAverageExamScore() {
        if (examScores.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double score : examScores) {

            sum += score;
        }
        return sum / examScores.size();

    }

    public String toString() {
        return null;
    }



}












