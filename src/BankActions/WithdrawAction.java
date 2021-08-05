package BankActions;

import java.util.Scanner;

import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class WithdrawAction implements Actions {
	
	private BankActions bankActions;
	private int amountRequested = 0;
	
	public WithdrawAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		return Bank.getCurrentUserUsingBank().getAccountType().getBalance() - amountRequested < 0;
	}

	@Override
	public void Action() {
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.PrintLine("Your current balance is <$" + Bank.getCurrentUserUsingBank().getAccountType().getBalance() + ">");
		TerminalPrinter.PrintLine("Enter amount to withdraw: ", false);
		amountRequested = scan.nextInt();
		if (Check()) {
			TerminalPrinter.PrintLine("Sorry you don\'t have enough cash to make this withdraw.");
			TerminalPrinter.PrintLine("Your current balance is <$" + Bank.getCurrentUserUsingBank().getAccountType().getBalance() + ">");
			bankActions.setBankingState();
			return;
		}
		TerminalPrinter.PrintLine("Thank you for your withdraw of <$" + amountRequested + ">");
		Bank.getCurrentUserUsingBank().getAccountType().useBalance(amountRequested);
		TerminalPrinter.PrintLine("Your new balance is <$" + Bank.getCurrentUserUsingBank().getAccountType().getBalance() + ">");
		bankActions.setBankingState();
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {user.getUsername(), " Withdraw -- The balance of "+ user.getAccountType().getAccountNumber() +" has been changed to " + user.getAccountType().getBalance()};
		return log;
	}


}
