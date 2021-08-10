package Main.StateMachine;

import Main.AccountsFactory.Account;
import Main.AccountsFactory.AccountFactory;
import Main.BankActions.BankActions;
import Main.Default.User;
import Main.Proxy.Pin;

class AccountVisitorImplTest {

    AccountVisitorImpl visitor;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        visitor = new AccountVisitorImpl();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void visitCredit() {
        Account creditacc = new AccountFactory().createAccount(1,10000);
        User user = new User();
        user.setAccountType(creditacc);
        user.setName(new String[]{"",""});
        user.setSSN("");
        user.setUsername("Credit");
        user.setPin(new Pin(1));

        BankActions bankActions = new BankActions();

        CreditBanking credit = new CreditBanking(user,bankActions);
        credit.accept(visitor);
    }

    @org.junit.jupiter.api.Test
    void visitDebit() {
        Account creditacc = new AccountFactory().createAccount(2,10000);
        User user = new User();
        user.setAccountType(creditacc);
        user.setName(new String[]{"",""});
        user.setSSN("");
        user.setUsername("Debit");
        user.setPin(new Pin(2));

        BankActions bankActions = new BankActions();

        DebitBanking debit = new DebitBanking(user,bankActions);
        debit.accept(visitor);
    }
}