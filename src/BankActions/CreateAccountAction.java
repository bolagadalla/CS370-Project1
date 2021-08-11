package BankActions;

import java.util.Scanner;

import AccountsFactory.AccountFactory;
import AccountsFactory.CreditCard;
import AccountsFactory.DebitCard;
import Default.User;
import Proxy.Pin;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class CreateAccountAction implements Actions {
	
	User newUser = new User();
	BankActions bankActions;
	
	public CreateAccountAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		return Bank.AddNewUser(newUser.getAccountType().getAccountNumber(), newUser);
	}

	@Override
	public void Action() {
		// Takes user input and add it to the new user Object
		AskForUserInfo();
		if (newUser.getAccountType() == null) return;
		// Checks if the user actually exists
		if (Check()) {
			TerminalPrinter.ClearConsole();
			TerminalPrinter.PrintLine("Account Successfuly Created\nYour Account Number is: " + newUser.getAccountType().getAccountNumber());
			TerminalPrinter.PrintLine("Your new balance is: $<" + newUser.getAccountType().getBalance() + ">");
			Bank.setCurrentUserUsingBank(newUser); // Sets the current user
			
			if (newUser.getAccountType().isCanTransfer()) {
				bankActions.getDebitBankingState().accept(bankActions.getAccountVisitor());
			}
			else
			{
				bankActions.getCreditBankingState().accept(bankActions.getAccountVisitor());
			}
			newUser = new User();
		}
		else
		{
			TerminalPrinter.ClearConsole();
			TerminalPrinter.PrintLine("You already have an account with that SSN.\nPlease log into that account.");
			newUser = new User();
			bankActions.setStartBankState();
		}
		
	}
	
	public void AskForUserInfo()
	{
		// Account Factory to create the Account object during runtime
		AccountFactory accountFactory = new AccountFactory();
		
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.ClearConsole();
		
		//--------------------------------OPENING AN ACCOUNT----------------------------------\\
		TerminalPrinter.PrintOptions("Which account would you like to open?", "Debit Account", "Credit Account");
		int accountType = scan.nextInt();
		
		switch (accountType) {
		case 1: {
			TerminalPrinter.PrintLine("Enter initial deposit: ", false);
			int initialAmount = scan.nextInt();
			newUser.setAccountType((DebitCard) accountFactory.createAccount(accountType, initialAmount));
			break;
		}
		case 2: {
			TerminalPrinter.PrintLine("Enter your current Credit Score: ", false);
			int creditScore = scan.nextInt();
			newUser.setAccountType((CreditCard) accountFactory.createAccount(accountType, CalculateCreditLimitAmount(creditScore)));
			break;
		}
        default: {
            System.err.println("Invalid option selected, You should enter 1) Credit Card or 2) Debit Card");
        	bankActions.setStartBankState();
            return;
        }
		}
		//--------------------------------ASKING PERSONAL INFO--------------------------------\\		
		
		TerminalPrinter.PrintLine("Enter your full name: ", false);
		String[] name = {"", ""};
		name[0] = (String) scan.next().strip();
		name[1] = scan.hasNext() ? (String) scan.next().strip() : "";
		newUser.setName(name);
		
		TerminalPrinter.PrintLine("Enter your SSN: ", false);
		String ssn = (String) scan.next().strip();
		newUser.setSSN(ssn);
		
		String username = name[0].toLowerCase() + name[1].toLowerCase() + Integer.toString((int)(Math.random()*(99-0+1)+0));
		TerminalPrinter.PrintLine("Your Username will now be: " + username);
		newUser.setUsername(username);
		
		TerminalPrinter.PrintLine("Type a Pin for your account: ", false);
		newUser.setPin(new Pin(scan.nextInt()));
	}
	
	public int CalculateCreditLimitAmount(int creditScore)
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
		User user = Bank.getCurrentUserUsingBank();
		String[] log;
		if (user == null) {
			log = new String[] {"System --", " Ready"};
		}
		else log = new String[] {user.getUsername(), " -- The new account : " + user.getAccountType().getAccountNumber() + " is created"};
		return log;
	}
}
