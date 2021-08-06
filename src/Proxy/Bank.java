package Proxy;

public interface Bank {
    double getBalance();
    void atmWithdraw(int cashOut);
    void setBalance(double newBalance);
    void atmDeposit(int cashIn);
}
