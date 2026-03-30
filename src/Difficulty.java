public enum Difficulty {
    EASY(1, 50, 15, 3),
    MEDIUM(1, 100, 10, 2),
    HARD(1, 200, 7, 1);

    final int min;
    final int max;
    final int maxAttempts;
    final int maxHints;

    Difficulty(int min, int max, int maxAttempts, int maxHints) {
        this.min = min;
        this.max = max;
        this.maxAttempts = maxAttempts;
        this.maxHints = maxHints;
    }
}
