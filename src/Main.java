import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        do {
            playGame(sc, rand);
        } while (askPlayAgain(sc));
        System.out.println("Thanks for playing, Goodbye!");
    }

    static int generateSecretNumber(Random random) {
        return random.nextInt(100) + 1;
    }

    static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            try {
                int guess = Integer.parseInt(input);
                if (guess < 0 || guess > 100) {
                    System.out.println("Invalid guess\n Please enter a number between 0 and 100");
                    continue;
                }
                return guess;
            } catch (NumberFormatException e) {
                System.out.println("Not a number!\n Please enter a VALID input");
            }
        }
    }

    static String checkGuess(int guess, int secret) {
        if (guess > secret) return "TOO_HIGH";
        else if (guess < secret) return "TOO_LOW";
        else return "CORRECT";
    }

    static boolean askPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Play again? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "yes", "y" -> {
                    return true;
                }
                case "no", "n" -> {
                    return false;
                }
                default -> {
                    System.out.println("Please type yes (y) or no (n).");
                }
            }
        }
    }

    static boolean playGame(Scanner scanner, Random random) {
        int randomNumber = generateSecretNumber(random);
        int attempts = 0;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100...");

        while (true) {
            int userGuess = getUserGuess(scanner);
            attempts++;

            String result = checkGuess(userGuess, randomNumber);

            if (result.equals("CORRECT")) {
                System.out.println("You got it! Attempts: " + attempts);
                return true;
            } else if (result.equals("TOO_HIGH")) {
                System.out.println("Too high, try lower.");
            } else {
                System.out.println("Too low, try higher.");
            }
        }
    }
}