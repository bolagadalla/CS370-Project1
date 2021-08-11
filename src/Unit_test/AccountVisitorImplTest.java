package Unit_test;

import static org.junit.Assert.assertSame;

import AccountsFactory.Account;
import AccountsFactory.AccountFactory;
import BankActions.BankActions;
import Default.User;
import Proxy.Pin;
import Singletons.Bank;
import StateMachine.CreditBanking;
import StateMachine.DebitBanking;
import Visitor.AccountVisitorImpl;

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
        user.getAccountType().generateAccountNumber();
        Bank.AddNewUser(user.getAccountType().getAccountNumber(), user);
        BankActions bankActions = new BankActions();

        CreditBanking credit = new CreditBanking(bankActions);
        credit.accept(visitor);
        assertSame(bankActions.getCreditBankingState(), bankActions.GetCurrentBankState());
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
        user.getAccountType().generateAccountNumber();
        Bank.AddNewUser(user.getAccountType().getAccountNumber(), user);
        BankActions bankActions = new BankActions();

        DebitBanking debit = new DebitBanking(bankActions);
        debit.accept(visitor);
        assertSame(bankActions.getDebitBankingState(), bankActions.GetCurrentBankState());
    }
}