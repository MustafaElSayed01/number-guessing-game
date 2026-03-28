# Number Guessing Game

A command-line Java game where the player selects a difficulty level and attempts to guess a randomly generated number within a limited number of attempts. After each incorrect guess, the game provides directional feedback and shows remaining attempts.

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

## Requirements

- Java 25 (LTS) — [Download from Adoptium](https://adoptium.net)

## Difficulty Levels

| Level  | Range   | Max Attempts |
|--------|---------|--------------|
| Easy   | 1 – 50  | 15           |
| Medium | 1 – 100 | 10           |
| Hard   | 1 – 200 | 7            |

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
1. Easy: Numbers between 1 and 50 with 15 valid attempt.
2. Medium: Numbers between 1 and 100 with 10 valid attempt.
3. Hard: Numbers between 1 and 200 with 7 valid attempt.
Enter choice (1/2/3): 2
Guess a number between 1 and 100...
Enter your guess: 50
Too high, try lower.
Remaining attempts: 9
Enter your guess: 25
Too low, try higher.
Remaining attempts: 8
Enter your guess: 37
You got it! Attempts: 3

Play again? (yes/no): n
Thanks for playing. Goodbye!
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