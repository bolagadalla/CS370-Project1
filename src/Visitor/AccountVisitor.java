package Visitor;

import StateMachine.CreditBanking;
import StateMachine.DebitBanking;

//vistor for concrete element
public interface AccountVisitor {
  //Deposit", "Withdraw", "Transfer", "Quit
  void visit(CreditBanking credit);

  void visit(DebitBanking debit);
}
