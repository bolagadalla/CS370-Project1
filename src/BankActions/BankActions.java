package BankActions;

import java.util.ArrayList;

import Default.User;
import Observers.MyObservable;
import Observers.MyObserver;

public class BankActions implements MyObservable {
	
	private User currentUserUsingBank;
	private ArrayList<MyObserver> observers;
	
	public BankActions(User currentUser)
	{
		setCurrentUserUsingBank(currentUser);
		observers = new ArrayList<MyObserver>();
	}
	
	/*
	 * Banks Have The Following Actions
	 * 
	 * Create Account
	 * Login To Account
	 * Deposit
	 * Withdraw
	 * Transfer
	 * Pay Credit Card
	 * 
	 */

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

	public User getCurrentUserUsingBank() {
		return currentUserUsingBank;
	}

	public void setCurrentUserUsingBank(User currentUserUsingBank) {
		this.currentUserUsingBank = currentUserUsingBank;
	}

}
