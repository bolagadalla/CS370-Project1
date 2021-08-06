package BankActions;

import java.util.Scanner;

import Default.User;
import Proxy.AtmProxy;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class WithdrawAction implements Actions {
	
	private BankActions bankActions;
	private Proxy.Bank atmProxy;
	
	private int amountRequested = 0;
	
	public WithdrawAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		return atmProxy.getBalance() - amountRequested < 0;
	}

	@Override
	public void Action() {
		atmProxy = new AtmProxy(Bank.getCurrentUserUsingBank().getPin(), bankActions.getBankBranch());
		
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.PrintLine("Your current balance is <$" + atmProxy.getBalance() + ">");
		TerminalPrinter.PrintLine("Enter amount to withdraw: ", false);
		amountRequested = scan.nextInt();
		if (Check()) {
			TerminalPrinter.PrintLine("Sorry you don\'t have enough cash to make this withdraw.");
			TerminalPrinter.PrintLine("Your current balance is <$" + atmProxy.getBalance() + ">");
			bankActions.setBankingState();
			return;
		}
		TerminalPrinter.PrintLine("Thank you for your withdraw of <$" + amountRequested + ">");
		bankActions.getBankBranch().setBalance(atmProxy.getBalance() - amountRequested);
		TerminalPrinter.PrintLine("Your new balance is <$" + atmProxy.getBalance() + ">");
		bankActions.setBankingState();
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {""};//  {user.getUsername(), "Withdraw -- The balance of "+ user.getAccountType().getAccountNumber() +" has been changed to " + user.getAccountType().getBalance()};
		return null;
	}


}
