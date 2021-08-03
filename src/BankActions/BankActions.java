package BankActions;

import java.util.ArrayList;

import Observers.MyObservable;
import Observers.MyObserver;
import Singletons.TerminalPrinter;
import StateMachine.BankStart;
import StateMachine.BankState;
import StateMachine.Banking;
import StateMachine.EndBank;

public class BankActions implements MyObservable {
	private ArrayList<MyObserver> observers;
	private ArrayList<Actions> actionsToTake;
	
	private BankState startBankState;
	private BankState bankingState;
	private BankState endBankState;
	
	private BankState currentBankState;
	
	public BankActions()
	{
		observers = new ArrayList<MyObserver>();
		actionsToTake = new ArrayList<Actions>();
		
		startBankState = new BankStart(this);
		bankingState = new Banking(this);
		endBankState = new EndBank(this);
		
		currentBankState = startBankState;
		currentBankState.BeginState();
	}
	
	/**
	 * Sets the currentBankState to a new state.
	 * @param newState - The new state that will be assigned to the BankActions' currentBankState. 
	 * */
	public void SetCurrentBankState(BankState newState)
	{
		currentBankState = newState;
		currentBankState.BeginState();
	}
	
	/**
	 * Returns the currentBankState of the BankActions class.
	 * @return The current state of the bank, this is a BankState interface object.
	 * */
	public BankState GetCurrentBankState()
	{
		return currentBankState;
	}
	
	/**
	 * Will call the BeginState method on the currentBankState Interface.
	 * So we only need to call this method to start a certain state that we are already on.
	 */
	public void BeginState()
	{
		currentBankState.BeginState();
	}
	
	public void TakeAction(int actionIndex)
	{
		if (actionIndex < 0 || actionIndex > actionsToTake.size() - 1) {
			// Will print this statement and exists out of this function
			// Since its called in a while loop, it will come back to this with a new input, so we dont need to take new input here.
			TerminalPrinter.PrintLine("Incorrect Input, please try again: ");
			return;
		}
		notifyListeners(actionsToTake.get(actionIndex).getMessage());
		ActionTakenInState(actionsToTake.get(actionIndex));
	}
	
	public void CreateNewActions(ArrayList<Actions> actions)
	{
		actionsToTake = actions;
	}
	
	public void setStartBankState() {SetCurrentBankState(startBankState);}
	public void setBankingState() {SetCurrentBankState(bankingState);}
	public void setEndBankState() {SetCurrentBankState(endBankState);}
	
	public BankState getStartBankState() {return startBankState;}
	
	
	//-----------------------------OBSERVERS FUNCTIONS-----------------------------------\\
	
	@Override
	public void notifyListeners(String[] actions) {
		for (MyObserver myObserver : observers) {
			myObserver.update(actions[0], actions[1]);
		}
	}

	@Override
	public void addListener(MyObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeListener(MyObserver observer) {
		observers.remove(observer);
	}
	
	//-----------------------------PRIVATE FUNCTIONS-------------------------------------\\
	
	/**
	 * Will call the ActionTakenInState method on the currentBankState interface.
	 * So we only need to call this method to take action on the current bank state.
	 * @param action - The action that will be taken on this state. This action is coming from the classes that implement the Actions Interface.
	 * */
	private void ActionTakenInState(Actions action)
	{
		currentBankState.ActionTakenInState(action);
	}
}


