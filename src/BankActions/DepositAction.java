package BankActions;

import java.util.Scanner;

import Singletons.Bank;
import Singletons.TerminalPrinter;

public class DepositAction implements Actions {

	BankActions bankActions;
	
	public DepositAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Action() {
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.ClearConsole();
		TerminalPrinter.PrintLine("Enter the amount you wish to deposit: ", false);
		int amountEntered = scan.nextInt();
		Bank.getCurrentUserUsingBank().getAccountType().addBalance(amountEntered);
		TerminalPrinter.PrintLine("Thank you for your deposit of $" + amountEntered);
		TerminalPrinter.PrintLine("Your new balance is <$" + Bank.getCurrentUserUsingBank().getAccountType().getBalance() + ">");
		bankActions.setBankingState();
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
