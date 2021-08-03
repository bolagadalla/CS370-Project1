# CS370-Project1

This is a group project for our CSCI 370 at Queens College with professor Aryeh Greenburg.

## Changes
- @jihoonk-1116 Implemented the Observer design pattern
	- An extra function `getMessages()` was created.
	- Implemented `getMessages()` to all the actions of the Bank.
	- Added Logger class to log to the user recent transactions.

- @hongdmo2 Implemented the Factory design pattern
	- Created `Account` interface which is implemented by `CreditCard` and `DebitCard` classes
	- `User` class takes in `Account` as a variable
	- The `AccountFactory` determines which account to assign to the User's Account.

- @bolagadalla
	- Implemented State Design to manage the different state the bank will be in.
	- Implemented all the actions in the BankActions except these:
  		- TransferAction
  		- PayCreditAction
	- Implemented the BankStart state, Banking State, EndBank State functionalities
	- Added Some Code in the TerminalPrinter