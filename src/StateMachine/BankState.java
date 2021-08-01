package StateMachine;

import BankActions.Actions;

public interface BankState {
	void BeginState();
	void ActionTakenInState(Actions action);
}
