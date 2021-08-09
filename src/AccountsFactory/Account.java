
package AccountsFactory;

//Creating Interface
public interface Account {
    double getBalance();

    void setBalance(double balance);

    boolean isCanTransfer();

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    boolean useBalance(double amountUsed);

    void addBalance(double amountAdded);

    double getCreditLimit();

    void setCreditLimit(double creditLimit);


}
