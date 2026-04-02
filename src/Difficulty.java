/**
 * Represents the available difficulty levels for the Number Guessing Game.
 *
 * <p>Each difficulty defines:
 * <ul>
 *   <li>The minimum number of the guessing range</li>
 *   <li>The maximum number of the guessing range</li>
 *   <li>The maximum number of attempts allowed</li>
 *   <li>The maximum number of hints available</li>
 * </ul>
 *
 * <p>The values are used to configure the game logic dynamically
 * depending on the selected difficulty level.
 */
public enum Difficulty {

    /**
     * Easy difficulty.
     *
     * <p>Range: 1–50<br>
     * Attempts: 15<br>
     * Hints: 3
     */
    EASY(1, 50, 15, 3),

    /**
     * Medium difficulty.
     *
     * <p>Range: 1–100<br>
     * Attempts: 10<br>
     * Hints: 2
     */
    MEDIUM(1, 100, 10, 2),

    /**
     * Hard difficulty.
     *
     * <p>Range: 1–200<br>
     * Attempts: 7<br>
     * Hints: 1
     */
    HARD(1, 200, 7, 1);

    /**
     * Minimum number in the guessing range.
     */
    private final int min;

    /**
     * Maximum number in the guessing range.
     */
    private final int max;

    /**
     * Maximum number of allowed attempts.
     */
    private final int maxAttempts;

    /**
     * Maximum number of hints available.
     */
    private final int maxHints;

    /**
     * Constructs a difficulty level with its configuration parameters.
     *
     * @param min         the minimum number in the guessing range
     * @param max         the maximum number in the guessing range
     * @param maxAttempts the maximum number of attempts allowed
     * @param maxHints    the maximum number of hints available
     */
    Difficulty(int min, int max, int maxAttempts, int maxHints) {
        this.min = min;
        this.max = max;
        this.maxAttempts = maxAttempts;
        this.maxHints = maxHints;
    }

    /**
     * Returns the minimum number allowed for this difficulty.
     *
     * @return minimum value of the guessing range
     */
    public int getMin() {
        return min;
    }

    /**
     * Returns the maximum number allowed for this difficulty.
     *
     * @return maximum value of the guessing range
     */
    public int getMax() {
        return max;
    }

    /**
     * Returns the maximum number of attempts allowed.
     *
     * @return maximum attempts for this difficulty
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Returns the maximum number of hints available.
     *
     * @return maximum hints allowed
     */
    public int getMaxHints() {
        return maxHints;
    }
}