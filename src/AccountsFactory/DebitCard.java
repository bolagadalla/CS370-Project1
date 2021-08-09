package AccountsFactory;

import java.util.Random;

public class DebitCard implements Account {
    private String accountNumber;
    private double balance;
    
    public DebitCard(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean isCanTransfer() {
        return true;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean useBalance(double amountUsed) {
        if (balance - amountUsed < 0) return false;
        balance -= amountUsed;
        return true;

    }

    @Override
    public void addBalance(double amountAdded) {
        balance += amountAdded;

    }

    @Override
    public double getCreditLimit() {
        System.out.println("NO CREDIT");
        return 0;
    }

    @Override
    public void setCreditLimit(double creditLimit) {
        System.err.println("Can't reach to the CreditLimit");
    }
    
    @Override
    public String toString() {
    	return "Debit Card" + "\nAccount Number:\t" + accountNumber + "\nBalance:\t$" + balance;
    }
    
	@Override
	public void generateAccountNumber() {
		Random random = new Random();
		accountNumber = Integer.toString(random.nextInt(900000 - 100000) + 100000); //Parse String
	}
}
