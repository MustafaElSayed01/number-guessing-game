# Number Guessing Game

A command-line Java game where the player attempts to guess a randomly generated number between 1 and 100. After each incorrect guess, the game provides directional feedback until the player finds the correct answer.

## Concepts Practiced

- Variables, data types, and operators
- `Scanner` for user input and `Random` for number generation
- `while` loops and `do-while` loops for game flow control
- `if/else` and `switch` expressions for branching logic
- Input validation using `try/catch` and `NumberFormatException`
- Method decomposition and single-responsibility design
- String comparison with `.equals()`

## Requirements

- Java 25 (LTS) — [Download from Adoptium](https://adoptium.net)

## How to Run

Clone the repository:

```bash
git clone https://github.com/MustafaElSayed01/number-guessing-game.git
cd number-guessing-game
```

Compile and run:

```bash
javac src/Main.java
java -cp src Main
```

## Sample Output

```
Welcome to Number Guessing Game!
Guess a number between 1 and 100...
Enter your guess: 50
Too high, try lower.
Enter your guess: 25
Too low, try higher.
Enter your guess: 37
You got it! Attempts: 3

Play again? (yes/no): n
Thanks for playing. Goodbye!
```

## Project Structure

```
number-guessing-game/
├── src/
│   └── Main.java
├── .gitignore
└── README.md
```