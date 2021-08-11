package Observers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Stack;

import Singletons.TerminalPrinter;

public class Logger implements MyObserver{
	
	private HashMap<String, Stack<String>> transactionLog; 
	//username : log
	//Last-in-first-out
	
	public Logger() {
		transactionLog = new HashMap<String, Stack<String>>();
	}
	
	@Override
	/*
	 * update function is called by Observerable class, mainly BankActions class.
	 * the function takes user name and transaction as parameters
	 * Then, the name is being used as key, and the transaction is being stored into the mapped Stack.  
	 */
	public void update(String action, String user) {
		
		TerminalPrinter.PrintLine("\nLogger notification: " + action + user);
		//if the key is inserted at first, create new stack
		
		if(!transactionLog.containsKey(user)) {
			Stack<String> newStack = new Stack<String>();
			transactionLog.put(user, newStack);
		}
		transactionLog.get(user).add(action + " -- " +  LocalDateTime.now().toString().substring(0,19));
		
	}
	/*
	 * print all transaction
	 */
	public void printAll() {
		TerminalPrinter.PrintLine("Name : Transaction");
		transactionLog.forEach((key, value) -> {
			TerminalPrinter.PrintLine(key + " : " + value);
		});
	}
	/*
	 * print an user's transaction
	 * @param - username as key 
	 */
	public void printByUserName(String username) {
		TerminalPrinter.PrintLine("Name : Transaction");
		TerminalPrinter.PrintLine(transactionLog.get(username).toString());
	}
}
