package StateMachine;

import java.util.ArrayList;

import BankActions.Actions;

public interface BankState {
	void BeginState();
	void ActionTakenInState(Actions action);
	ArrayList<Actions> StateActions();
}
