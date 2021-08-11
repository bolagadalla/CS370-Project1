package BankActions;

import java.util.ArrayList;

import Observers.MyObservable;
import Observers.MyObserver;
import Proxy.BankBranch;
import Singletons.Bank;
import Singletons.TerminalPrinter;
import StateMachine.BankStart;
import StateMachine.BankState;
import StateMachine.CreditBanking;
import StateMachine.DebitBanking;
import StateMachine.EndBank;
import Visitor.AccountVisitorImpl;

public class BankActions implements MyObservable {
	private ArrayList<MyObserver> observers;
	private ArrayList<Actions> actionsToTake;
	
	private Proxy.Bank bankBranch;
	
	private BankState startBankState;
	private BankState debitBankingState;
	private BankState creditBankingState;
	private BankState endBankState;
	
	private BankState currentBankState;
	
	private AccountVisitorImpl accountVisitor;
	
	public BankActions()
	{
		observers = new ArrayList<MyObserver>();
		actionsToTake = new ArrayList<Actions>();
		startBankState = new BankStart(this);
		setStartBankState();
		
		debitBankingState = new DebitBanking(this);
		creditBankingState = new CreditBanking(this);
		endBankState = new EndBank(this);
		
		accountVisitor = new AccountVisitorImpl();
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
			TerminalPrinter.PrintLine("Incorrect Input, please try again.");
			setStartBankState();
			return;
		}
		ActionTakenInState(actionsToTake.get(actionIndex));
	}
	
	public void CreateNewActions(ArrayList<Actions> actions)
	{
		actionsToTake = actions;
	}
	public int ActionsCount() { return actionsToTake.size(); }
	public ArrayList<Actions> getActions() { return actionsToTake; } 
	public void setStartBankState() {
		SetCurrentBankState(startBankState);
		setBankBranch(null);
		Bank.setCurrentUserUsingBank(null);
	}
	
	public void setDebitBankingState() {
		SetCurrentBankState(debitBankingState);
		if (bankBranch == null) {
			setBankBranch(new BankBranch(Bank.getCurrentUserUsingBank()));	
		}	
	}
	
	public void setCreditBankingState() {
		SetCurrentBankState(creditBankingState);
		if (bankBranch == null) {
			setBankBranch(new BankBranch(Bank.getCurrentUserUsingBank()));	
		}	
	}
	
	public void setEndBankState() {
		SetCurrentBankState(endBankState);
	}
	
	public BankState getStartBankState() {return startBankState;}
	public CreditBanking getCreditBankingState() { return (CreditBanking) creditBankingState; }
	public DebitBanking getDebitBankingState() { return (DebitBanking) debitBankingState; }
	
	public BankBranch getBankBranch() {
		return (BankBranch) bankBranch;
	}

	public void setBankBranch(Proxy.Bank bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	public AccountVisitorImpl getAccountVisitor() {
		return accountVisitor;
	}
	
	//-----------------------------OBSERVERS FUNCTIONS-----------------------------------\\
	
		@Override
		/*
		 * This method will be used to notify a system event or user action to registered listeners ex) logger class
		 * @param action - action[0] : action detail  action[1] : user name
		 */
		public void notifyListeners(String[] action) {
			for (MyObserver myObserver : observers) {
				myObserver.update(action[0], action[1]);
			}
		}

		@Override
		/*
		 * Register observer object to gather or know user's action and system event
		 * @param observer - the object that wants to be notified
		 */
		public void addListener(MyObserver observer) {
			observers.add(observer);
		}

		@Override
		/*
		 * Unregister observer to stop to be notified actions and events
		 * @param observer - the object that wants to be notified
		 */
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
			
			notifyListeners(action.getMessage());
			//When an action or event are taken place, registered listeners will be notified by calling notifyListeners() method.
			//Each action class has getMessage() method to return specific message as String array for each of the actions 
		}
	}