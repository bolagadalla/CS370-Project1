package BankActions;

import java.util.Scanner;

import AccountsFactory.CreditCard;
import AccountsFactory.DebitCard;
import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;
import StateMachine.BankStart;
import StateMachine.Banking;

public class CreateAccountAction implements Actions {
	
	User newUser = new User();
	BankActions bankActions;
	
	public CreateAccountAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		return Bank.AddNewUser(newUser.getAccountNumber(), newUser);
	}

	@Override
	public void Action() {
		// Takes user input and add it to the new user Object
		AskForUserInfo();
		// Checks if the user actually exists
		if (Check()) {
			TerminalPrinter.ClearConsole();
			TerminalPrinter.PrintLine("Your new balance is: $" + newUser.getAccountType().getBalance());
			Bank.setCurrentUserUsingBank(newUser); // Sets the current user
			bankActions.setBankingState(); // Goes to next state
		}
		else
		{
			TerminalPrinter.ClearConsole();
			TerminalPrinter.PrintLine("You already have an account with us.\nPlease log into that account.");
			bankActions.setStartBankState();
		}
		
	}
	
	public void AskForUserInfo()
	{
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.ClearConsole();
		//--------------------------------OPENING AN ACCOUNT----------------------------------\\
		TerminalPrinter.PrintOptions("Which account would you like to open?", "Checking Account", "Credit Account");
		int accountType = scan.nextInt();
		
		switch (accountType) {
		case 1: {
			TerminalPrinter.PrintLine("Enter initial deposit: ", false);
			double initialAmount = scan.nextDouble();
			newUser.setAccountType(new DebitCard(initialAmount));
			break;
		}
		case 2: {
			TerminalPrinter.PrintLine("Enter your current Credit Score: ", false);
			int creditScore = scan.nextInt();
			newUser.setAccountType(new CreditCard(CalculateCreditLimitAmount(creditScore)));
			break;
		}
		
		}
		//--------------------------------ASKING PERSONAL INFO--------------------------------\\		
		
		TerminalPrinter.PrintLine("Enter your full name: ", false);
		String[] name = {"", ""};
		name[0] = (String) scan.next().strip();
		name[1] = scan.hasNext() ? (String) scan.next().strip() : "";
		newUser.setName(name);
		
		
		String username = name[0].toLowerCase() + name[1].toLowerCase() + Integer.toString((int)(Math.random()*(99-0+1)+0));
		TerminalPrinter.PrintLine("Your Username will now be: " + username);
		newUser.setUsername(username);
		
		TerminalPrinter.PrintLine("Type a Password for your account: ", false);
		newUser.setPassword((String) scan.next().strip());
	}
	
	public double CalculateCreditLimitAmount(int creditScore)
	{
		// equation: (creditScore * 3) - maximumSubtractionFromCreditLimit %
		int maximumSubtractionFromCreditLimit = 65; // 65%

		if (creditScore >= 300 && creditScore <= 500) {
			maximumSubtractionFromCreditLimit -= 20;
		}
		else if (creditScore > 500 && creditScore <= 700) {
			maximumSubtractionFromCreditLimit -= 40;
		}
		else if (creditScore > 700 && creditScore <= 800) {
			maximumSubtractionFromCreditLimit -= 65;
		}
		
		return (creditScore * 3) - ((creditScore * 3) * (maximumSubtractionFromCreditLimit / 100));
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
