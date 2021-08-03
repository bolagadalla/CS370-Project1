package AccountsFactory;

public class AccountFactory {
    public Account createAccount(int accountType, int balance) {
        switch (accountType) {
            case 1:
                return new CreditCard(balance);

            case 2:
                return new DebitCard(balance);
        }

        return null;
    }

}
