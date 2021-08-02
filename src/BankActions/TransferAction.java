package BankActions;

import Singletons.Bank;

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
		// Ask for account number to transfer to
		// Ask for the amount to transfer
		// Check if we can do that.
		// If we can then we complete the transfer
			// Add amountToTransfer to the account you're transferring to 
			// Subtract amountToTransfer from currentUserUsingBank account
			// Print transfer is complete
			// Go to banking state
		// Otherwise print whether the user doesnt exist or the amount is too large
		// Go to banking state
		
		
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}


}
