import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int BURNING_THRESHOLD  = 10;
    private static final int WARM_THRESHOLD     = 20;
    private static final int COLD_THRESHOLD     = 40;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Number Guessing Game!");
        do {
            playGame(scanner, random);
        } while (askPlayAgain(scanner));
        System.out.println("Thanks for playing, Goodbye!");
    }

    static Difficulty chooseDifficulty(Scanner scanner) {
        System.out.println("\nChoose your difficulty:");
        System.out.println("1. Easy: Numbers between 1 and 50 with 15 valid attempt.");
        System.out.println("2. Medium: Numbers between 1 and 100 with 10 valid attempt.");
        System.out.println("3. Hard: Numbers between 1 and 200 with 7 valid attempt.");

        while (true) {
            System.out.print("Enter choice(1/2/3):");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    return Difficulty.EASY;
                }
                case "2" -> {
                    return Difficulty.MEDIUM;
                }
                case "3" -> {
                    return Difficulty.HARD;
                }
                default -> {
                    System.out.println("Invalid choice, Please pick from 1 to 3!");
                }
            }
        }
    }

    static int generateSecretNumber(Random random, Difficulty difficulty) {
        return random.nextInt(difficulty.min, difficulty.max + 1);
    }

    static int getUserGuess(Scanner scanner, Difficulty difficulty) {
        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            try {
                int guess = Integer.parseInt(input);
                if (guess < difficulty.min || guess > difficulty.max) {
                    System.out.printf("Please enter a number between %d and %d.%n", difficulty.min, difficulty.max);
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

    static String getProximityHint(int distance){
        if (distance <= BURNING_THRESHOLD) return "Burning — you're very close!";
        else if (distance <= WARM_THRESHOLD) return "Warm — getting there.";
        else if (distance <= COLD_THRESHOLD) return "Cold — not quite.";
        else return "Freezing — way off!";
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

    static void playGame(Scanner scanner, Random random) {
        Difficulty difficulty = chooseDifficulty(scanner);
        int randomNumber = generateSecretNumber(random, difficulty);
        int attempts = 0;
        System.out.printf("Guess a number between %d and %d...%n", difficulty.min, difficulty.max);

        while (attempts < difficulty.maxAttempts) {
            int userGuess = getUserGuess(scanner, difficulty);
            attempts++;

            String result = checkGuess(userGuess, randomNumber);

            if (result.equals("CORRECT")) {
                System.out.println("You got it! Attempts: " + attempts);
                return;
            } else {
                System.out.println(result.equals("TOO_HIGH") ? "Too high, try lower." : "Too low, try higher.");
                int distance = Math.abs(userGuess - randomNumber);
                String proximityHint = getProximityHint(distance);
                System.out.println(proximityHint);
                System.out.printf("Remaining attempts: %d%n", difficulty.maxAttempts -  attempts);
            }
        }
        System.out.println("Out of attempts! The number was: " + randomNumber);
    }
}