package BankActions;

import Default.User;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class QuitBanking implements Actions {

	BankActions bankActions;
	
	public QuitBanking(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	/**
	 * Checks to see if the current bank state is the start state.
	 * */
	@Override
	public boolean Check() {
		return bankActions.GetCurrentBankState() == bankActions.getStartBankState();
	}

	/**
	 * If the state is the start state then we exit the program. if its not then we go to the start state.
	 * */
	@Override
	public void Action() {
		TerminalPrinter.ClearConsole();
		if (Check()) {
			Bank.saveBankState();
			System.exit(0);
		}
		bankActions.setStartBankState();
	}

	@Override
	public String[] getMessage() {
		User user = Bank.getCurrentUserUsingBank();
		String[] log = {user.getUsername(), "  Quit"};
		return log;
	}

}
