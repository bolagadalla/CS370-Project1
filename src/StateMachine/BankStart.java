package StateMachine;

import java.util.ArrayList;

import BankActions.Actions;
import BankActions.BankActions;
import BankActions.CreateAccountAction;
import BankActions.LoginAction;
import BankActions.QuitBanking;
import Singletons.TerminalPrinter;

public class BankStart implements BankState {

	BankActions bankActions;
	ArrayList<Actions> stateActions;
	
	public BankStart(BankActions bankActions)
	{
		this.bankActions = bankActions;
		stateActions = new ArrayList<Actions>();
		stateActions.add(new LoginAction(bankActions));
		stateActions.add(new CreateAccountAction(bankActions));
		stateActions.add(new QuitBanking(bankActions));
	}
	
	/**
	 * Prints the welcome screen
	 * Prints the actions of this states
	 * Initialize the Actions for the bankActions
	 * */
	@Override
	public void BeginState() {
		System.out.println();
		TerminalPrinter.PrintOptions("What would you like to do?", "Login To Bank", "Create Bank Account", "Quit Bank");
		bankActions.CreateNewActions(stateActions);
	}

	@Override
	public void ActionTakenInState(Actions action) {
		action.Action();
	}

	@Override
	public ArrayList<Actions> StateActions() {
		return stateActions;
	}
}
