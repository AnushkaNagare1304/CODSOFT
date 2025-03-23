import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsWon = 0; // Track rounds won
        boolean playAgain = true;
        
        System.out.println(" Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a number between 1-100
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\n New Round Started! Guess the number between 1 and 100.");
            
            while (!guessedCorrectly) {
                System.out.print("Your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                    roundsWon++;
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" Too low! Try again.");
                } else {
                    System.out.println(" Too high! Try again.");
                }
            }
            
            // Show user's score based on rounds won
            System.out.println(" Rounds Won: " + roundsWon);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();
            
            if (!userResponse.equals("yes")) {
                playAgain = false;
                System.out.println("\n Game Over! Total Rounds Won: " + roundsWon);
            }
        }
        
        scanner.close();
    }
}
