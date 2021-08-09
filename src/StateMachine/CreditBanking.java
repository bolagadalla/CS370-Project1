package StateMachine;

import java.util.ArrayList;

import BankActions.*;
import Singletons.Bank;
import Singletons.TerminalPrinter;
import Visitor.AccountElement;
import Visitor.AccountVisitor;

public class CreditBanking implements BankState, AccountElement {

	BankActions bankActions;
	ArrayList<Actions> stateActions;
	
	public CreditBanking(BankActions bankActions)
	{
		this.bankActions = bankActions;
		stateActions = new ArrayList<Actions>();
		stateActions.add(new WithdrawAction(bankActions));
		stateActions.add(new PayCreditAction(bankActions));
		stateActions.add(new QuitBanking(bankActions));
	}
	
	public BankActions getActions()
    {
        return this.bankActions;
    }
	
	@Override
	public void BeginState() {
		System.out.println();
		TerminalPrinter.PrintOptions("How can we help you today?", "Use Credit Card", "Pay Credit Card", "Quit");
		bankActions.CreateNewActions(stateActions);
	}

	@Override
	public void ActionTakenInState(Actions action) {
		action.Action();
	}

	@Override
	public void accept(AccountVisitor visitor) {
		visitor.visit(this);
	}

}
