package BankActions;

public class PayCreditAction implements Actions {

	BankActions bankActions;
	
	public PayCreditAction(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Action() {
		// Print Enter amount you would like to pay from your credit card
		// Store that amount into a variable
		// Subtract it from currentUserUsingBank account Credit balance
		// Print amount paid successful
		// Go to banking state
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}


}
