package AccountsFactory;

public abstract class AccountType {
	private String accountNumber;
	private double balance;
	private boolean canTransfer;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean isCanTransfer() {
		return canTransfer;
	}
	public void setCanTransfer(boolean canTransfer) {
		this.canTransfer = canTransfer;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public boolean useBalance(double amountUsed)
	{
		if (balance - amountUsed < 0) return false;
		
		balance -= amountUsed;
		return true;
	}
	
	public void addBalance (double amountAdded)
	{
		balance += amountAdded;
	}
}
