package Unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AccountsFactory.CreditCard;
import AccountsFactory.DebitCard;

class AccountFactory_Test {

	@Test
	void testUseBalance() {
		CreditCard creditcard = new CreditCard(99.0);
		creditcard.setBalance(100.0);
		assertTrue(creditcard.useBalance(50));
	}
	@Test
	void testaddBalance() {
		DebitCard debitcard = new DebitCard(100.0);
		debitcard.addBalance(50.0);
		assertEquals(150.0, debitcard.getBalance());
	}	

}
