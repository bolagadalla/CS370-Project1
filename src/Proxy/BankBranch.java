package Proxy;

import Default.User;

public class BankBranch implements Bank {
    private User realAccount;
    public BankBranch(User account) {
        this.realAccount = account;
    }

    public double getBalance() {
        return realAccount.getAccountType().getBalance();
    }

    public void atmWithdraw(int cashAmount){
        System.out.println("Successfully withdrawn");
        realAccount.getAccountType().useBalance(cashAmount);
    }
    public void setBalance(double newBalance){
        realAccount.getAccountType().setBalance(newBalance);
    }
   
    public void atmDeposit(int cashIn){
        System.out.println("Successfully Deposited");
        realAccount.getAccountType().addBalance(cashIn);
    }

}
