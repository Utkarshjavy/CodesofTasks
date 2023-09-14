import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take marks obtained in each subject
        System.out.println("Enter marks obtained (out of 100) in each subject:");

        int totalMarks = 0;
        int totalSubjects = 0;

        while (true) {
            System.out.print("Subject " + (totalSubjects + 1) + " (or -1 to finish): ");
            int marks = scanner.nextInt();

            if (marks == -1) {
                break;
            }

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                continue;
            }

            totalMarks += marks;
            totalSubjects++;
        }

        if (totalSubjects == 0) {
            System.out.println("No valid subjects provided.");
            return;
        }

        // Calculate Total Marks
        System.out.println("\nTotal Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / totalSubjects;
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

        // Grade Calculation
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Grade: " + grade);
    }
}
