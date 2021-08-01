package BankActions;

import java.util.Scanner;

import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;
import StateMachine.BankStart;
import StateMachine.Banking;

public class LoginAction implements Actions{
	
	BankActions bankActions;
	
	private String currentUserUsername;
	private String currentUserPassword;
	
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
		TerminalPrinter.PrintLine("Please Enter Username: ");
		// Read Input and assign it to currentUserUsername
		currentUserUsername = (String) scan.next().strip();
		TerminalPrinter.PrintLine("Please Enter Password: ");
		// Read input and assign it to currentUserPassword
		currentUserPassword = (String) scan.next().strip();
		System.out.println("Currently is always true");
		User user = Bank.getUser(currentUserUsername);
		// return user.getUsername() == currentUserUsername && user.getPassword() == currentUserPassword;
		return currentUserUsername == "Bola" && currentUserPassword == "123456";
	}
	
	/**
	 * If the user credential is correct it will go to the Banking State.
	 * Otherwise, it will go to the BankStart State.
	 * */
	@Override
	public void Action() {
		if (Check()) {
			TerminalPrinter.PrintLine("Login Success!");
			bankActions.SetCurrentBankState(new Banking(bankActions));
		}
		else
		{
			TerminalPrinter.PrintLine("Credentials are incorrect");
			bankActions.SetCurrentBankState(new BankStart(bankActions));
		}
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCurrentUserUsername(String currentUserUsername) {
		this.currentUserUsername = currentUserUsername;
	}

	public void setCurrentUserPassword(String currentUserPassword) {
		this.currentUserPassword = currentUserPassword;
	}


}
