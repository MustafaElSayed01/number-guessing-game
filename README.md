# Number Guessing Game

A command-line Java game where the player selects a difficulty level and attempts to guess a randomly generated number within a limited number of attempts. After each incorrect guess, the game provides directional feedback, a hot/cold proximity hint, and shows remaining attempts. Players can also request hints to reveal clues about the secret number.

## Concepts Practiced

- Variables, data types, and operators
- `Scanner` for user input and `Random` for number generation
- `while` loops and `do-while` loops for game flow control
- `if/else` and `switch` expressions for branching logic
- Input validation using `try/catch` and `NumberFormatException`
- Method decomposition and single-responsibility design
- String comparison with `.equals()`
- Enums with fields and constructors
- `printf` for formatted console output
- Ternary operator for compact conditionals
- Static final constants to avoid magic numbers
- `Math.abs()` for computing proximity distance
- Sentinel return values for invalid input signaling
- `ArrayList` for dynamic guess history tracking
- `HashMap` for per-difficulty best score tracking
- `entrySet()` for iterating over key-value pairs
- `getOrDefault()` for safe map access with fallback values

## Requirements

- Java 25 (LTS) — [Download from Adoptium](https://adoptium.net)

## Difficulty Levels

| Level  | Range   | Max Attempts | Hints |
|--------|---------|--------------|-------|
| Easy   | 1 – 50  | 15           | 3     |
| Medium | 1 – 100 | 10           | 2     |
| Hard   | 1 – 200 | 7            | 1     |

## Proximity Hints

After each wrong guess the game tells you how close you are:

| Distance from secret | Hint                         |
|----------------------|------------------------------|
| 1 – 10               | Burning — you're very close! |
| 11 – 20              | Warm — getting there.        |
| 21 – 40              | Cold — not quite.            |
| 41+                  | Freezing — way off!          |

## How to Run

Clone the repository:
```bash
git clone https://github.com/MustafaElSayed01/number-guessing-game.git
cd number-guessing-game
```

Compile and run:
```bash
javac src/Main.java src/Difficulty.java
java -cp src Main
```

## Sample Output
```
Welcome to Number Guessing Game!

Choose your difficulty:
1. Easy: Numbers between 1 and 50 with 15 valid attempt and 3 Hints.
2. Medium: Numbers between 1 and 100 with 10 valid attempt and 2 Hints.
3. Hard: Numbers between 1 and 200 with 7 valid attempt and 1 Hint.
Enter choice (1/2/3): 3
Guess a number between 1 and 200...
Type hint for a hint!
Enter your guess: 100
Too low, try higher.
Freezing — way off!
Remaining attempts: 6 Remaining hints: 1
Enter your guess: hint
The secret number is: ODD
Remaining hints: 0
Enter your guess: 149
Too high, try lower.
Burning — you're very close!
Remaining attempts: 5 Remaining hints: 0
Enter your guess: 141
Congratulations, You got it in 3 attempts!
Your guesses: [100, 149, 141]

Play again? (yes/no): n

--- Session Best Scores ---
Best Score for EASY: 3 attempts
Best Score for MEDIUM: 4 attempts
Thanks for playing, Goodbye!
```

## Project Structure
```
number-guessing-game/
├── src/
│   ├── Difficulty.java
│   └── Main.java
├── .gitignore
└── README.md
```

## Author

Mustafa ElSayed — [GitHub](https://github.com/MustafaElSayed01) · [LinkedIn](https://www.linkedin.com/in/mustafaelsayed01)