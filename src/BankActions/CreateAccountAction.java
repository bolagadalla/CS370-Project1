package BankActions;

import java.util.Scanner;

import AccountsFactory.CreditCard;
import AccountsFactory.DebitCard;
import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;
import StateMachine.Banking;

public class CreateAccountAction implements Actions {
	
	User newUser = new User();
	BankActions bankActions;
	
	public CreateAccountAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		Bank.getInstance();
		// TODO Auto-generated method stub
		return !Bank.checkUserExist(newUser.getAccountNumber());
	}

	@Override
	public void Action() {
		// Takes user input and add it to the new user Object
		AskForUserInfo();
		// Checks if the user actually exists
		if (!Check()) return;
		// If it doesnt exit then it will continue to here
		// We add the new user to the bank and make them the currentUserUsingBank
		Bank.AddNewUser(newUser.getAccountNumber(), newUser);
		TerminalPrinter.PrintLine("Your new balance is: $" + newUser.getAccountType().getBalance());
		Bank.setCurrentUserUsingBank(newUser); // Sets the current user
		bankActions.SetCurrentBankState(new Banking(bankActions)); // Goes to next state
	}
	
	public void AskForUserInfo()
	{
		Scanner scan = new Scanner(System.in);
		//--------------------------------OPENING AN ACCOUNT----------------------------------\\
		TerminalPrinter.PrintOptions("Which account would you like to open?", "Checking Account", "Credit Account");
		int accountType = scan.nextInt();
		
		switch (accountType) {
		case 1: {
			TerminalPrinter.PrintLine("What would be your initial deposit");
			double initialAmount = scan.nextDouble();
			newUser.setAccountType(new DebitCard(initialAmount));
		}
		case 2: {
			TerminalPrinter.PrintLine("What is your current Credit Score?");
			int creditScore = scan.nextInt();
			newUser.setAccountType(new CreditCard(CalculateCreditLimitAmount(creditScore)));
		}
		
		}
		//--------------------------------ASKING PERSONAL INFO--------------------------------\\		
		
		TerminalPrinter.PrintLine("What is your full name?");
		String[] name = {"", ""};
		name[0] = (String) scan.next().strip();
		name[1] = scan.hasNext() ? (String) scan.next().strip() : "";
		newUser.setName(name);
		
		
		String username = name[0].toLowerCase() + name[1].toLowerCase() + Integer.toString((int)(Math.random()*(99-0+1)+0));
		TerminalPrinter.PrintLine("Your Username will now be: " + username);
		newUser.setUsername(username);
		
		TerminalPrinter.PrintLine("Type a Password for your account: ");
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
