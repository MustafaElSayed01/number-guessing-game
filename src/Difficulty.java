public enum Difficulty {
    EASY(1, 50, 15),
    MEDIUM(1, 100, 10),
    HARD(1, 200, 7);

    final int min;
    final int max;
    final int maxAttempts;

    Difficulty(int min, int max, int maxAttempts) {
        this.min = min;
        this.max = max;
        this.maxAttempts = maxAttempts;
    }
}
