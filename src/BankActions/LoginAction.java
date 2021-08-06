package BankActions;

import java.util.Scanner;

import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class LoginAction implements Actions{
	
	BankActions bankActions;
	private User user;
	private String currentUserAccountNumber;
	private int currentUserPin;
	
	public LoginAction(BankActions bankActions)
	{
		this.bankActions = bankActions;
	}
	
	/**
	 * If the username and password are correct this will return true.
	 * @return Whether the user's username exists and if the password is correct or not. If both are true, it will return true.
	 */
	@Override
	public boolean Check() {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		TerminalPrinter.PrintLine("Please Enter Your Account Number: ", false);
		// Read Input and assign it to currentUserUsername
		currentUserAccountNumber = (String) scan.nextLine();
		TerminalPrinter.PrintLine("Please Enter Password: ", false);
		// Read input and assign it to currentUserPassword
		currentUserPin = scan.nextInt();
		user = Bank.getUser(currentUserAccountNumber); // Will return null if the user doesnt exist, so we only need to check if the user exists or not
		return user != null && user.getPin().checkPin(currentUserPin);
	}
	
	/**
	 * If the user credential is correct it will go to the Banking State.
	 * Otherwise, it will go to the BankStart State.
	 * */
	@Override
	public void Action() {
		if (Check()) {
			TerminalPrinter.PrintLine("Login Success!");
			Bank.setCurrentUserUsingBank(user);
			bankActions.setBankingState();
		}
		else
		{
			TerminalPrinter.ClearConsole();
			TerminalPrinter.PrintLine("Credentials are incorrect");
			user = null;
			bankActions.setStartBankState();
		}
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {""}; // {user.getUsername(), " -- Login "};
		return null;
	}
}
