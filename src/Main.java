import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Entry point for the Number Guessing Game.
 * <p>
 * The game allows the player to choose a difficulty level and guess a randomly
 * generated number within a limited number of attempts. The player may also
 * request hints during gameplay. Best scores are tracked per difficulty level
 * for the duration of the session.
 */
public class Main {

    /**
     * Distance threshold for "Burning" proximity hint.
     */
    private static final int BURNING_THRESHOLD = 10;

    /**
     * Distance threshold for "Warm" proximity hint.
     */
    private static final int WARM_THRESHOLD = 20;

    /**
     * Distance threshold for "Cold" proximity hint.
     */
    private static final int COLD_THRESHOLD = 40;

    /**
     * Application entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        HashMap<Difficulty, Integer> bestScores = new HashMap<>();

        System.out.println("Welcome to Number Guessing Game!");

        do {
            playGame(scanner, random, bestScores);
        } while (askPlayAgain(scanner));

        if (!bestScores.isEmpty()) {
            System.out.println("\n--- Session Best Scores ---");
            for (HashMap.Entry<Difficulty, Integer> entry : bestScores.entrySet()) {
                System.out.printf("Best Score for %s is %d attempts!%n",
                        entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Thanks for playing, Goodbye!");
    }

    /**
     * Prompts the player to choose a difficulty level.
     *
     * @param scanner scanner used to read user input
     * @return selected {@code Difficulty} level
     */
    static Difficulty chooseDifficulty(Scanner scanner) {

        System.out.println("\nChoose your difficulty:");
        System.out.println("1. Easy: Numbers between 1 and 50 with 15 valid attempt and 3 Hints.");
        System.out.println("2. Medium: Numbers between 1 and 100 with 10 valid attempt and 2 Hints.");
        System.out.println("3. Hard: Numbers between 1 and 200 with 7 valid attempt and 1 Hint.");

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
                default -> System.out.println("Invalid choice, Please pick from 1 to 3!");
            }
        }
    }

    /**
     * Generates a random secret number within the difficulty range.
     *
     * @param random     random number generator
     * @param difficulty selected difficulty level
     * @return randomly generated secret number
     */
    static int generateSecretNumber(Random random, Difficulty difficulty) {
        return random.nextInt(difficulty.getMin(), difficulty.getMax() + 1);
    }

    /**
     * Validates and converts user input into an integer guess.
     *
     * @param input      raw user input
     * @param difficulty current difficulty level
     * @return parsed guess if valid, otherwise {@code -1}
     */
    static int getUserGuess(String input, Difficulty difficulty) {
        try {
            int guess = Integer.parseInt(input);

            if (guess < difficulty.getMin() || guess > difficulty.getMax()) {
                System.out.printf(
                        "Please enter a number between %d and %d.%n",
                        difficulty.getMin(), difficulty.getMax());
                return -1;
            }

            return guess;

        } catch (NumberFormatException e) {
            System.out.println("Not a number! Please enter a valid input.");
            return -1;
        }
    }

    /**
     * Compares the user's guess with the secret number.
     *
     * @param guess  player's guessed number
     * @param secret secret number to be guessed
     * @return {@code "TOO_HIGH"}, {@code "TOO_LOW"}, or {@code "CORRECT"}
     */
    static String checkGuess(int guess, int secret) {
        if (guess > secret) return "TOO_HIGH";
        else if (guess < secret) return "TOO_LOW";
        else return "CORRECT";
    }

    /**
     * Returns a proximity hint based on the distance between the guess
     * and the secret number.
     *
     * @param distance absolute difference between guess and secret
     * @return descriptive proximity hint
     */
    static String getProximityHint(int distance) {

        if (distance <= BURNING_THRESHOLD)
            return "Burning — you're very close!";

        else if (distance <= WARM_THRESHOLD)
            return "Warm — getting there.";

        else if (distance <= COLD_THRESHOLD)
            return "Cold — not quite.";

        else
            return "Freezing — way off!";
    }

    /**
     * Asks the player whether they want to start another round.
     *
     * @param scanner scanner used to read user input
     * @return {@code true} if the player chooses to continue,
     * {@code false} otherwise
     */
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
                default -> System.out.println("Please type yes (y) or no (n).");
            }
        }
    }

    /**
     * Provides a hint indicating whether the secret number
     * is even or odd.
     *
     * @param secret secret number
     * @return {@code "EVEN"} if the number is even, otherwise {@code "ODD"}
     */
    static String getHint(int secret) {
        return secret % 2 == 0 ? "EVEN" : "ODD";
    }

    /**
     * Updates the best score for the specified difficulty level.
     *
     * @param bestScores map storing best scores for each difficulty
     * @param difficulty difficulty level played
     * @param attempts   number of attempts used in the current round
     * @return {@code true} if the current score is a new best score,
     * {@code false} otherwise
     */
    static boolean updateBestScore(
            HashMap<Difficulty, Integer> bestScores,
            Difficulty difficulty,
            int attempts) {

        int currentBest = bestScores.getOrDefault(difficulty, Integer.MAX_VALUE);

        if (attempts < currentBest) {
            bestScores.put(difficulty, attempts);
        }

        return attempts < currentBest;
    }

    /**
     * Runs a full round of the guessing game.
     * <p>
     * Handles difficulty selection, number generation, user guesses,
     * hint usage, attempt tracking, and score updates.
     *
     * @param scanner    scanner used to read user input
     * @param random     random number generator
     * @param bestScores map storing best scores per difficulty
     */
    static void playGame(
            Scanner scanner,
            Random random,
            HashMap<Difficulty, Integer> bestScores) {

        Difficulty difficulty = chooseDifficulty(scanner);
        int secret = generateSecretNumber(random, difficulty);

        int attempts = 0;
        int hintsRemaining = difficulty.getMaxHints();

        ArrayList<Integer> guesses = new ArrayList<>();

        System.out.printf("Guess a number between %d and %d...%n",
                difficulty.getMin(), difficulty.getMax());

        System.out.println("Type hint for a hint!");

        while (attempts < difficulty.getMaxAttempts()) {

            System.out.print("Enter your guess: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            if (userInput.equals("hint")) {

                if (hintsRemaining == 0) {
                    System.out.println("You have reached the maximum number of hints.");
                } else {
                    System.out.println("The secret number is: " + getHint(secret));
                    hintsRemaining--;
                    System.out.println("Remaining hints: " + hintsRemaining);
                }

                continue;
            }

            int userGuess = getUserGuess(userInput, difficulty);

            if (userGuess == -1)
                continue;

            guesses.add(userGuess);
            attempts++;

            String result = checkGuess(userGuess, secret);

            if (result.equals("CORRECT")) {

                System.out.printf("Congratulations, You got it in %d attempts%n", attempts);
                System.out.println("Your guesses: " + guesses);

                if (updateBestScore(bestScores, difficulty, attempts)) {
                    System.out.printf("New Best Score For %s : %d attempts!%n",
                            difficulty, attempts);
                } else {
                    int bestScore = bestScores.get(difficulty);
                    System.out.printf("Best Score For %s is still %d attempts!%n",
                            difficulty, bestScore);
                }

                return;
            }

            System.out.println(
                    result.equals("TOO_HIGH")
                            ? "Too high, try lower."
                            : "Too low, try higher."
            );

            int distance = Math.abs(userGuess - secret);

            String proximityHint = getProximityHint(distance);

            System.out.println(proximityHint);

            System.out.printf(
                    "Remaining attempts: %d Remaining hints: %d%n",
                    difficulty.getMaxAttempts() - attempts,
                    hintsRemaining
            );
        }

        System.out.println("Out of attempts! The number was: " + secret);
        System.out.println("Your guesses: " + guesses);
    }
}