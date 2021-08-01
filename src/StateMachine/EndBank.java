package StateMachine;

import BankActions.Actions;
import BankActions.BankActions;

public class EndBank implements BankState {

	BankActions bankActions;
	
	public EndBank(BankActions bankActions)
	{
		this.bankActions = bankActions;
	}
	
	@Override
	public void BeginState() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ActionTakenInState(Actions action) {
		action.Action();
	}

}
