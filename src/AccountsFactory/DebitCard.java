package AccountsFactory;

public class DebitCard extends AccountType {
	public DebitCard(double initialAmount)
	{
		setBalance(initialAmount);
		setCanTransfer(true);
	}
}
