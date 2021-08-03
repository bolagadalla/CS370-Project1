package AccountsFactory;

import java.util.Random;

public class DebitCard implements Account {
    private String accountNumber;
    private double balance;
    private boolean canTransfer;
    private boolean canDeposit;

    public DebitCard(double balance) {
        Random random = new Random();
        int acc = random.nextInt(900000 - 100000) + 100000;

        this.accountNumber = Integer.toString(acc);
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
        return false;
    }

    @Override
    public void setCanTransfer(boolean canTransfer) {
        this.canTransfer = canTransfer;
    }

    @Override
    public boolean isCanDeposit() {
        return true;
    }

    @Override
    public void SetCanDeposit(boolean canDeposit) {
        this.canDeposit = canDeposit;
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
}
