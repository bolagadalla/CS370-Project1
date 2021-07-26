package BankActions;

import java.util.ArrayList;

import Default.User;
import Observers.MyObservable;
import Observers.MyObserver;

public class BankActions implements MyObservable {
	private ArrayList<MyObserver> observers;
	/*
	 * List of all possible actions that can be taken at the moment
	 * i.e.
	 * 1) Deposit <-- 1 possible action
	 * 2) Withdraw
	 * 3) Transfer
	 * */
	private ArrayList<Actions> actionsToTake;
	
	public BankActions(User currentUser)
	{
		observers = new ArrayList<MyObserver>();
		actionsToTake = new ArrayList<Actions>();
	}
	
	public void TakeAction(int actionIndex)
	{
		actionsToTake.get(actionIndex);
	}

	@Override
	public void notifyListeners(String actions) {
		for (MyObserver myObserver : observers) {
			myObserver.update(actions);
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

}
