package Default;

import Singletons.Bank;
import Singletons.TerminalPrinter;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Bank bank = Bank.getInstance();
		TerminalPrinter terminalPrinter = TerminalPrinter.getInstance();
		terminalPrinter.PrintWelcome();
		terminalPrinter.PrintOptions("Which of these are you looking to do?", "Deposit", "Withdraw", "Transfer", "Quit");
	}

}
