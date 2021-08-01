package StateMachine;

import BankActions.Actions;
import BankActions.BankActions;

public class LoginBank implements BankState {

	BankActions bankActions;
	
	public LoginBank(BankActions bankActions)
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
