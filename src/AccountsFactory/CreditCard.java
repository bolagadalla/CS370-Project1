package AccountsFactory;

public class CreditCard extends AccountType{
	public CreditCard (double creditLimit)
	{
		setBalance(creditLimit);
		setCanTransfer(false);
	}
}
