package BankActions;

import java.util.Scanner;

import Default.User;
import Proxy.BankBranch;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class TransferAction implements Actions {

	private BankActions bankActions;
	// The account number of the user you want to transfer to.
	private String accountNumberToTransfer;
	private int amountToTransfer;
	
	public TransferAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	/**
	 * @return Returns true if the user transferring to exists and the amount you're transferring will not go to the negative.
	 * */
	@Override
	public boolean Check() {
		return Bank.checkUserExist(accountNumberToTransfer) && Bank.getCurrentUserUsingBank().getAccountType().getBalance() - amountToTransfer >= 0;
	}

	@Override
	public void Action() {
		Scanner scan = new Scanner(System.in);
		TerminalPrinter.PrintLine("Enter account number of recipient: ", false);
		accountNumberToTransfer = Integer.toString(scan.nextInt());
		
		if (!Bank.checkUserExist(accountNumberToTransfer) || accountNumberToTransfer == Bank.getCurrentUserUsingBank().getAccountType().getAccountNumber()) {
			if (!Bank.checkUserExist(accountNumberToTransfer)) TerminalPrinter.PrintLine("Sorry this account doesn\'t exist");
			if (accountNumberToTransfer == Bank.getCurrentUserUsingBank().getAccountType().getAccountNumber()) TerminalPrinter.PrintLine("You can\'t transfer money to yourself silly.");
			goToBanking();
		}
		
		TerminalPrinter.PrintLine("Enter amount to transfer: ", false);
		amountToTransfer = scan.nextInt();
		if (Check()) {
			// Subtracts amount from current user
			bankActions.getBankBranch().setBalance(bankActions.getBankBranch().getBalance() - amountToTransfer); 
			Bank.getUser(accountNumberToTransfer).getAccountType().addBalance(amountToTransfer);
			TerminalPrinter.PrintLine("Transfer to account <" + accountNumberToTransfer + "> of the amount <$" + amountToTransfer + "> was successful");
			goToBanking();
		}
		else
		{
			TerminalPrinter.PrintLine("Sorry, you don\'t have the required amount to complete this transaction.");
			goToBanking();
		}
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
		String[] log = {user.getUsername(), "  Transfer of <$" + amountToTransfer + "> is complete"};
		return log;
	}



}
