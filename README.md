# CPSC 3148 - Assignment 6

## Files
- `WeeklySpending.java`: one-dimensional array of seven daily expenses.
- `MovieSeats.java`: two-dimensional boolean array for 4 rows of 6 seats.
- `Reflection.txt`: short reflection on the assignment.
- `screenshots/`: actual program execution screenshots.

## Run
Open a terminal in this folder and run:

```bash
javac WeeklySpending.java MovieSeats.java
java WeeklySpending
java MovieSeats
```

## Testing
WeeklySpending: try `19`, `11`, `26`, `22`, `32`, `139.99`, `80.65`. Total should be `$330.64`, average `$47.23`, highest Saturday `$139.99`. Also try an invalid word or a negative amount to see the validation message.

MovieSeats: reserve row 4 seat 3, then try it again to see the taken-seat message. Try row 5 seat 3, and row 2 seat 7 to see the invalid-seat message. Enter row 0 to finish. The board uses `O` for open and `X` for taken.

## Submit
Upload this folder to GitHub, then submit the repository link and reflection to Blackboard as instructed. Include screenshots showing both successful runs and invalid inputs.
