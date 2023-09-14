import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playGame();
    }

    static int generateRandomNumber(int lowerLimit, int upperLimit) {
        Random random = new Random();
        return random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
    }

    static int guessNumber(int lowerLimit, int upperLimit, int secretNumber) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.print("Try to guess the number " + lowerLimit + " and " + upperLimit + ": ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! The number you guessed is right " + attempts + " attempts.");
                return attempts;
            } else if (userGuess < secretNumber) {
                System.out.println("Your input is too low. Try with another input");
            } else {
                System.out.println("Your input is too high. Try with another input");
            }
        }
    }

    static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = 1;
        int upperLimit = 100;
        int totalAttempts = 0;
        int rounds = 0;

        while (true) {
            rounds++;
            int secretNumber = generateRandomNumber(lowerLimit, upperLimit);
            System.out.println("\nchance " + rounds);
            totalAttempts += guessNumber(lowerLimit, upperLimit, secretNumber);

            System.out.print("Wanna play the game again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nYou played " + rounds + " rounds.");
        System.out.println("Your average attempts per round: " + (double) totalAttempts / rounds);
    }
}

