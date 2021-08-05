package AccountsFactory;

import java.util.Random;

public class CreditCard implements Account {
    private String accountNumber;
    private double balance;
    private double creditLimit;
    private boolean canTransfer;
    private boolean canDeposit;


    public CreditCard(double balance) {
        Random random = new Random();
        int acc = random.nextInt(900000 - 100000) + 100000; // setup for accountNumber
        this.creditLimit = balance;
        this.accountNumber = Integer.toString(acc); //Parse String
        this.balance = balance;
    }


    @Override
    public double getBalance() { //return balance
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean isCanDeposit() { //CreditCard can't deposit money into
        return false;
    }

    @Override
    public void SetCanDeposit(boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    @Override
    public boolean isCanTransfer() { //CreditCard can't transfer money to another.
        return false;
    }

    @Override
    public void setCanTransfer(boolean canTransfer) {
        this.canTransfer = canTransfer;
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
        return creditLimit;
    }

    @Override
    public void setCreditLimit(double AdjustCredit) {
        this.creditLimit = AdjustCredit;
    }
    
    @Override
    public String toString() {
    	return "Credit Card" + "\nAccount Number:\t" + accountNumber + "\nCredit Limit:\t" + creditLimit;
    }
}
