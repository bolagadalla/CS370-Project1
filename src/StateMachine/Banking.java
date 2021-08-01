package StateMachine;

import java.util.ArrayList;

import BankActions.*;
import Singletons.TerminalPrinter;

public class Banking implements BankState {

	BankActions bankActions;
	ArrayList<Actions> stateActions;
	
	public Banking(BankActions bankActions)
	{
		this.bankActions = bankActions;
		stateActions = new ArrayList<Actions>();
		stateActions.add(new DepositAction());
		stateActions.add(new WithdrawAction());
		stateActions.add(new TransferAction());
	}
	
	@Override
	public void BeginState() {
		System.out.println();
		TerminalPrinter.PrintOptions("How can we help you today?", "Deposit", "Withdraw", "Transfer", "Quit");
		bankActions.CreateNewActions(stateActions);
	}

	@Override
	public void ActionTakenInState(Actions action) {
		action.Action();
	}

}
