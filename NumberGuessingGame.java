package task1.codsoft;


import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int roundsWon = 0;
        
        while (true) {
            totalRounds++;
            System.out.println("Round " + totalRounds);
            
            int targetNumber = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            
            boolean guessedCorrectly = false;
            
            while (attemptsLeft > 0) {
                System.out.println("You have " + attemptsLeft + " attempts left.");
                System.out.print("Enter your guess (1 to 100): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Invalid input. Please guess a number between 1 and 100.");
                    continue;
                }
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
                
                attemptsLeft--;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! You ran out of attempts. The correct number was: " + targetNumber);
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            
            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        System.out.println("Game Over! You won " + roundsWon + " out of " + totalRounds + " rounds.");
        
        scanner.close();
    }
}
