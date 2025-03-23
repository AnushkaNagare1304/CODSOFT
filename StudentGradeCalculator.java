import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int totalMarks = 0;
        
        // Input marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            
            // Validate input (marks should be between 0 and 100)
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter again (0-100): ");
                marks = scanner.nextInt();
            }
            
            totalMarks += marks;
        }
        
        // Calculate percentage
        double percentage = (double) totalMarks / numSubjects;
        
        // Determine Grade
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F'; // Fail
        }

        // Display results
        System.out.println("\n Student Grade Report:");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
