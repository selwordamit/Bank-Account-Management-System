# Bank Account Management System in Java

This project is a simple Bank Account Management System that allows users to perform basic operations like depositing, withdrawing, and transferring money between accounts. It simulates a banking system with a user interface through the console, and implements basic account management functionalities.

## OOP Concepts Demonstrated
- Classes and Objects
- Inheritance
- Polymorphism
- Encapsulation

## Features
- **Account Creation**: Allows creating new bank accounts.
- **Deposit**: Deposit money into a specific account.
- **Withdraw**: Withdraw money from a specific account (ensuring sufficient balance).
- **Transfer**: Transfer money between two bank accounts.
- **Transaction History**: Keep track of deposits, withdrawals, and transfers for each account.
- **User Input Handling**: Use of `InputUtils` class for handling user input with validation.

## Classes and Their Purpose

- **BankAccount**: Represents a basic bank account. It holds account details (like account number, balance) and supports operations like deposit, withdrawal, and getting account details.
- **SavingAccount**: Extends `BankAccount` with additional features like interest rate functionality.
- **CurrentAccount**: Extends `BankAccount` and include overdraft functionality.
- **BankService**: Manages operations for multiple bank accounts, including deposit, withdraw, transfer, and transaction history management.
- **InputUtils**: Utility class for reading and validating user input from the console.
