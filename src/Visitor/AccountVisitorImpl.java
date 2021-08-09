package Visitor;

import StateMachine.CreditBanking;
import StateMachine.DebitBanking;

public class AccountVisitorImpl implements AccountVisitor {

	@Override
	public void visit(CreditBanking credit) {
		credit.getActions().setCreditBankingState();
	}

	@Override
	public void visit(DebitBanking debit) {
		debit.getActions().setDebitBankingState();
	}

}
