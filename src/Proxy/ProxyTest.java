package Proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AccountsFactory.Account;
import AccountsFactory.AccountFactory;
import Default.User;

class ProxyTest {
	
    @Test
    void testWithdraw() {
        //fail("Not yet implemented");
    	User testuser = Singletons.Bank.getUser("0");
    	Singletons.Bank.setCurrentUserUsingBank(testuser);
    	
        BankBranch testBranch = new BankBranch(testuser);
        AtmProxy testProxy = new AtmProxy(testuser.getPin(), (BankBranch) testBranch);
        testProxy.atmWithdraw(500);
        assertEquals(500, testProxy.getBalance());
    }
    @Test
    void testDeposit() {
        //fail("Not yet implemented");
    	User testuser = Singletons.Bank.getUser("0");
    	Singletons.Bank.setCurrentUserUsingBank(testuser);
    	
        BankBranch testBranch = new BankBranch(testuser);
        AtmProxy testProxy = new AtmProxy(testuser.getPin(), (BankBranch) testBranch);
        testProxy.atmDeposit(1000);
        assertEquals(1500, testProxy.getBalance());
    }
    
    @Test
    void testChangeAccount() {
        //fail("Not yet implemented");
    	User testuser = Singletons.Bank.getUser("0");
    	Singletons.Bank.setCurrentUserUsingBank(testuser);
    	
        BankBranch testBranch = new BankBranch(testuser);
        AtmProxy testProxy = new AtmProxy(testuser.getPin(), (BankBranch) testBranch);
        testProxy.setBalance(99999);
        assertNotEquals(99999, testProxy.getBalance());
    }
}
