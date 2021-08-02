package StateMachine;

import BankActions.Actions;
import BankActions.BankActions;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class EndBank implements BankState {

	BankActions bankActions;
	
	public EndBank(BankActions bankActions)
	{
		this.bankActions = bankActions;
	}
	
	@Override
	public void BeginState() {
		TerminalPrinter.PrintWelcome(); // Prints the welcome header.
		Bank.setCurrentUserUsingBank(null); // sets the current user using the bank to be null.
		bankActions.setStartBankState(); // Go to the Start bank state.
	}

	@Override
	public void ActionTakenInState(Actions action) {
		// TODO Auto-generated method stub
	}

}
