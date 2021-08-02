# CS370-Project1

This is a group project for our CSCI 370 at Queens College with professor Aryeh Greenburg.

## Changes
- @jihoonk-1116 Implemented the Observer design pattern
	- An extra function `getMessages()` was created.
	- Implemented `getMessages()` to all the actions of the Bank.
	- Added Logger class to log to the user recent transactions.

- @bolagadalla
	- Implemented State Design to manage the different state the bank will be in.
	- Implemented all the actions in the BankActions except these:
  		- TransferAction
  		- PayCreditAction
  		- QuitAction
	- Implemented the BankStart state, Banking State, EndBank State functionalities
	- Added Some Code in the TerminalPrinter