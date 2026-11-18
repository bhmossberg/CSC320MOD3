# CSC320MOD3 – Decision Structures and Tax Withholding

Java console programs that use `if`/`else` chains and `switch` statements to make decisions, centered on a progressive (marginal) weekly tax-withholding calculator.

## Overview

This is **CSU Global CSC320 (Programming I), Module 3**. Module 3 covers variables, operators and branching (Chapter 3 of *Programming in Java with zyLabs*). It is an Eclipse Java project (the `.settings` file sets compiler compliance to Java 24). All sources sit in the repository root, in the default package.

## Assigned course work

### `AverageWitholdingMarginal.java` (Module 3 Critical Thinking)
This program reads a weekly salary and works out a **progressive (marginal) tax withholding**.
- **Input validation:** the program reads a line, parses it with `Double.parseDouble`, and rejects negative or non-numeric entries. After 3 failed attempts it exits with "Too many invalid attempts".
- **Bracket logic:** an `if / else if` chain works out how much of the weekly income falls into each bracket:

  | Weekly income slice | Rate |
  |---|---|
  | $0 – $499.99 | 10% |
  | $500 – $1,499.99 | 15% |
  | $1,500 – $2,499.99 | 20% |
  | $2,500 and up | 30% |

  It records the top bracket reached as the **marginal rate**. Each slice is multiplied by its rate, and the results are added together.
- **Output:** annual income (weekly × 52), estimated annual tax, the marginal rate, the average (effective) rate (total tax ÷ income), and the average weekly withholding.

Sample run (verified):
```
Enter your weekly salary:
1800
You entered $1800.00.
Annual income: $93600.00
Estimated total tax burden: $13520.05
Marginal tax rate: 20%
Average tax rate: 14.44%
Average weekly tax withholding: $260.00
```
(The slice boundaries are coded as `499.99` and `2499.99`, so the annual total can differ by a few cents from the cleaner math in `AverageWitholdingMarginalv2`.)

## Additional practice

### `AverageWitholding.java`
Additional practice that applies a **flat tax**: the bracket the salary falls in sets one rate (10/15/20/30%), and that rate applies to the whole income. It uses the same 3-attempt input validation and prints the annual salary, the rate applied, the annual tax and the weekly withholding. For example, $1,800 a week gives a 20% flat rate and $360.00 a week.

### `AverageWitholdingMarginalv2.java`
Additional practice in a different format with more modularity. The user enters their weekly income **and configures all four brackets** (three upper limits and four rates). Two reusable helper methods do the input work:
- `getPositiveDouble(Scanner, String prompt)` accepts a value ≥ 0 and allows 3 attempts before `System.exit(1)`.
- `getTaxRate(Scanner, String prompt)` accepts a percentage from 0 to 100 and also allows 3 attempts.

It prints a formatted report (`%,.2f`, `"=".repeat(50)`) showing weekly and annual income, weekly and annual tax, the marginal rate and the average rate. With the default brackets, $1,800 a week gives $260.00 a week, $13,520.00 a year, and rates of 20% marginal and 14.44% average.

### `Seasons.java`
The ZyLabs Chapter 3 assignment that outputs the season for a user-entered month and day (for example `April 11` → `Spring`).
- It converts the month and day into a **Julian (day-of-year) date**. A Java 14+ **switch expression** (`case "march" -> 59;`) maps each month to the number of days before it, and the day is added on.
- A classic `switch` with fall-through cases checks the day against the month's length (Feb ≤ 29; Apr/Jun/Sep/Nov ≤ 30; others ≤ 31).
- Ranges of the day-of-year pick the season: 79–171 Spring, 172–264 Summer, 265–354 Autumn, 355–365 or 1–78 Winter. Bad input prints `Invalid`.

### `ChangeMaker.java`
This program reads an amount in cents and uses integer division and subtraction to print the fewest dollars, quarters, dimes, nickels and pennies, choosing singular or plural for each. For example, `389` → `3 Dollars, 3 Quarters, 1 Dime, 4 Pennies`. An input of `0` prints `No change`.

### `LeapYear.java`
This program reads a year and applies the Gregorian rule: the year is divisible by 400, or it is divisible by 4 and not by 100. For example, `1712 is a leap year.`

### `NameFormat.java`
This program reads a full name, splits it on whitespace with `split("\\s+")`, and reformats it. "First Last" becomes `Last, First`, and "First Middle Last" becomes `Last, First M.`. For example, `Pat Silly Doe` → `Doe, Pat S.`. Any other number of names prints an error message.

## Build and run

Each file is a standalone program with its own `main`. Most compile with JDK 8+. `Seasons.java` needs **JDK 14 or newer** because it uses a switch expression.

```bash
javac AverageWitholdingMarginal.java
java AverageWitholdingMarginal
```

You can also import the folder into Eclipse as an existing project. The `.project`, `.classpath` and `.settings` files are included.

## Concepts demonstrated
- `if` / `else if` / `else` chains and compound boolean conditions
- Classic `switch` (with fall-through) and the modern switch expression
- Input validation with `try`/`catch (NumberFormatException)` and attempt counters
- Integer division and the modulus operator (change making, leap years)
- `String` methods: `split`, `substring`, `toLowerCase`, `trim`
- Formatted output with `printf`
- Breaking a program into helper methods (`AverageWitholdingMarginalv2`)

## Required

- [ ] Chapter 3 in Programming in Java with zyLabs
- [ ] Oracle. (2022). Variables.
- [ ] Oracle. (2022). Operators.

## Recommended

- [ ] Home and Learn. (n.d.). IF...else.
- [ ] Gassner, D. (2018). Java essential training: Syntax and structure. LinkedIn Learning.

## Assignments

- [ ] Discussion
- [ ] Critical Thinking
