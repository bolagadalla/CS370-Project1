package Observers;

import java.time.LocalDateTime;
import java.util.HashMap;

import Singletons.TerminalPrinter;

public class Logger implements MyObserver{
	
	private HashMap<String, String> transactionLog;
	
	public Logger() {
		transactionLog = new HashMap<String, String>();
	}
	
	@Override
	public void update(String action, String user) {
		TerminalPrinter.PrintLine("Logger : " + action);
		
		transactionLog.put(user , action + "\tDate: " 
				+ LocalDateTime.now());
	}

	
	public void textwriter() {
		//write transaction log in a text file
	}
	
	public void print() {
		TerminalPrinter.PrintLine("Name : Transaction");
		
		transactionLog.forEach((key, value) -> {
			TerminalPrinter.PrintLine(key + " : " + value);
		});
		
	}
}
