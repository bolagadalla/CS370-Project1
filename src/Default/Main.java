package Default;

import java.util.Scanner;

import BankActions.BankActions;
import Singletons.TerminalPrinter;

public class Main {

	public static void main(String[] args) {
		TerminalPrinter.PrintWelcome();
		BankActions bankActions = new BankActions();
		Scanner scan = new Scanner(System.in);
		while (bankActions.ActionsCount() != 0) {
			scan = new Scanner(System.in);
			bankActions.TakeAction(scan.nextInt() - 1);
		}
		scan.close();
	}

}// 7182832900
