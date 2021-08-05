package AccountsFactory;
//Creating a Factory to generate object of concrete class based on given information
//using createAccount method to get object of type of card, either credit or debit

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
