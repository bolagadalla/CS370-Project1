package Default;

import java.util.Scanner;

import BankActions.BankActions;
import Singletons.Bank;
import Singletons.TerminalPrinter;

public class Main {

	public static void main(String[] args) {
		TerminalPrinter.PrintWelcome();
		BankActions bankActions = new BankActions();
		Scanner scan = new Scanner(System.in);
		while (true) {
			bankActions.TakeAction(scan.nextInt() - 1);
			scan = new Scanner(System.in);
		}
	}

}
