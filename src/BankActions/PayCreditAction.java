package BankActions;

import java.util.Scanner;

import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class PayCreditAction implements Actions {

	BankActions bankActions;
	
	public PayCreditAction(BankActions bankActions) {
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
		TerminalPrinter.PrintLine("Enter amount you would like to pay for credit card: ", false);
		int amountToPay = scan.nextInt();
		Bank.getCurrentUserUsingBank().getAccountType().setBalance(Bank.getCurrentUserUsingBank().getAccountType().getBalance() + amountToPay);
		TerminalPrinter.PrintLine("Payment has been made, thank you!");
		goToBanking();
	}
	
	private void goToBanking()
	{
		if (Bank.getCurrentUserUsingBank().getAccountType().isCanTransfer()) {
			bankActions.getDebitBankingState().accept(bankActions.getAccountVisitor());
		}
		else
		{
			bankActions.getCreditBankingState().accept(bankActions.getAccountVisitor());
		}
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {user.getUsername(), "  Pay credit"};
		return log;
	}



}
