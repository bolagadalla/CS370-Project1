package Singletons;

import java.util.HashMap;

import AccountsFactory.DebitCard;
import Default.User;
import Proxy.Pin;

public class Bank {
	static HashMap<String, User> users = new HashMap<String, User>();
	static Bank bank = new Bank();
	static User currentUserUsingBank;

	private Bank() {
		User user = new User(new DebitCard("0", 1000), new String[] {"John", "Smith"}, "johnsmith90", "", "123456789", new Pin(1234));
		users.put(user.getAccountType().getAccountNumber(), user);
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
	
	private static boolean checkSSNUserExist(User user)
	{
		// Loops through the users to see if there are any user with the same SSN and account type that they are creating
		for (User s : users.values()) {
			if (s.getSSN() == user.getSSN() && (s.getAccountType().isCanTransfer() == user.getAccountType().isCanTransfer())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean AddNewUser(String userID, User user)
	{
		// Makes sure the account number is not in use
		if (!checkUserExist(userID) && !checkSSNUserExist(user)) {
			users.put(userID, user);
			saveBankState();
			return true;
		}
		
		return false;
	}
	
	private static void printAccounts()
	{
		System.out.println();
		for (User u : users.values()) {
			System.out.println(u.toString());
			System.out.println();
		}
	}

	public static User getCurrentUserUsingBank() {
		return currentUserUsingBank;
	}

	public static void setCurrentUserUsingBank(User currentUserUsingBank) {
		Bank.currentUserUsingBank = currentUserUsingBank;
	}
}
