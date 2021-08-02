package BankActions;

public class QuitBanking implements Actions {

	BankActions bankActions;
	
	public QuitBanking(BankActions bankActions) {
		this.bankActions = bankActions;
	}
	
	@Override
	public boolean Check() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Action() {
		// Go to the EndBank state. using the bankActions
	}

	@Override
	public String[] getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
