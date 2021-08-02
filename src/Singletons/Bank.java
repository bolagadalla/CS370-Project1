package Singletons;

import java.util.HashMap;

import Default.User;

public class Bank {
	static Bank bank = new Bank();
	static HashMap<String, User> users = new HashMap<String, User>();
	static User currentUserUsingBank;

	private Bank() {
		// READ JSON FILE FOR ALL THE ACCOUNTS
		
	}
	
	/**
	 * Saves the state of the bank. 
	 * Saves the transactions and the User's new account changes for next time use
	 * */
	public static void saveBankState()
	{
		
	}
	
	public static Bank getInstance()
	{
		return bank;
	}
	
	public static User getUser(String userID)
	{
		return users.get(userID);
	}
	
	public static boolean checkUserExist(String userID)
	{
		return users.containsKey(userID);
	}
	
	public static boolean AddNewUser(String userID, User user)
	{
		if (!users.containsKey(userID)) {
			users.put(userID, user);
			saveBankState();
			return true;
		}
		return false;
	}

	public static User getCurrentUserUsingBank() {
		return currentUserUsingBank;
	}

	public static void setCurrentUserUsingBank(User currentUserUsingBank) {
		Bank.currentUserUsingBank = currentUserUsingBank;
	}
}
