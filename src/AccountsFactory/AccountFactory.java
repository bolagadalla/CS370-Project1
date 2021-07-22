package AccountsFactory;

public class AccountFactory {
	public AccountType createAccount(int accountType, double balance) // 1 - Credit Card, 2 - Debit Card
	{
		AccountType account = null;
		
		if (accountType == 1) {
			return new CreditCard(balance);
		}
		else if (accountType == 2)
		{
			return new DebitCard(balance);
		}
		return account;
	}
}
