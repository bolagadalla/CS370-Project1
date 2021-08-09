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
		if (Bank.getCurrentUserUsingBank().getAccountType().isCanTransfer()) {
			DialogForDebit(scan);
		}
		else
		{
			DialogForCredit(scan);
		}
	}
	
	private void DialogForDebit(Scanner scan)
	{
		TerminalPrinter.PrintLine("Your current balance is <$" + atmProxy.getBalance() + ">");
		TerminalPrinter.PrintLine("Enter amount to withdraw: ", false);
		amountRequested = scan.nextInt();
		if (Check()) {
			TerminalPrinter.PrintLine("Sorry you don\'t have enough cash to make this withdraw.");
			TerminalPrinter.PrintLine("Your current balance is <$" + atmProxy.getBalance() + ">");
			bankActions.setDebitBankingState();
			return;
		}
		TerminalPrinter.PrintLine("Thank you for your withdraw of <$" + amountRequested + ">");
		bankActions.getBankBranch().setBalance(atmProxy.getBalance() - amountRequested);
		TerminalPrinter.PrintLine("Your new balance is <$" + atmProxy.getBalance() + ">");
		bankActions.setDebitBankingState();
	}
	
	private void DialogForCredit(Scanner scan)
	{
		TerminalPrinter.PrintLine("Your current credit limit is <$" + atmProxy.getBalance() + ">");
		TerminalPrinter.PrintLine("Enter amount to use: ", false);
		amountRequested = scan.nextInt();
		if (Check()) {
			TerminalPrinter.PrintLine("Sorry you don\'t have enough cash to make this withdraw.");
			TerminalPrinter.PrintLine("Your current credit limit is <$" + atmProxy.getBalance() + ">");
			bankActions.setCreditBankingState();
			return;
		}
		TerminalPrinter.PrintLine("Thank you for using your credit card - <$" + amountRequested + "> has been used.");
		bankActions.getBankBranch().setBalance(atmProxy.getBalance() - amountRequested);
		TerminalPrinter.PrintLine("Your new credit limit is <$" + atmProxy.getBalance() + ">");
		bankActions.setCreditBankingState();
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {user.getUsername(), " Withdraw -- The balance of "+ user.getAccountType().getAccountNumber() +" has been changed to " + user.getAccountType().getBalance()};
		return log;
	}


}
