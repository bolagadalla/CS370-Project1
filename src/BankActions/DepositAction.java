package BankActions;

import java.util.Scanner;

import Default.User;
import Proxy.AtmProxy;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class DepositAction implements Actions {

	BankActions bankActions;
	Proxy.Bank atmProxy;

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
		atmProxy = new AtmProxy(Bank.getCurrentUserUsingBank().getPin(), bankActions.getBankBranch());
		
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.ClearConsole();
		TerminalPrinter.PrintLine("Enter the amount you wish to deposit: ", false);
		int amountEntered = scan.nextInt();
		atmProxy.atmDeposit(amountEntered);
		TerminalPrinter.PrintLine("Thank you for your deposit of <$" + amountEntered + ">");
		TerminalPrinter.PrintLine("Your new balance is <$" + atmProxy.getBalance() + ">");
		bankActions.setDebitBankingState();
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {user.getUsername(), " Deposit -- The balance of "+ user.getAccountType().getAccountNumber()+" has been changed to " + user.getAccountType().getBalance()};
		return log;
	}

}
