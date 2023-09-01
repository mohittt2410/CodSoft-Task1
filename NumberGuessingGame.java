package NumberGameTask1;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts) + 1;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.println("Current Score: " + score);
            
            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.next();
            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }
            
            rounds++;
        } while (true);
        
        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}