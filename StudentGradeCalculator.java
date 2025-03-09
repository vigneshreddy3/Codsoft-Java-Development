package task1.codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int NUM_SUBJECTS = 5;
        int[] marks = new int[NUM_SUBJECTS];
        
        System.out.println("Enter the marks obtained in " + NUM_SUBJECTS + " subjects (out of 100):");
        int totalMarks = 0;
        
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        double averagePercentage = (double) totalMarks / NUM_SUBJECTS;
        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (NUM_SUBJECTS * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
