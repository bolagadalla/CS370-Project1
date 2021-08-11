package Unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BankActions.BankActions;

class BankActionTest {

	@Test
	void endStateTest() {
		BankActions test = new BankActions();
		test.setDebitBankingState();
		test.setEndBankState();
		assertSame(test.getStartBankState(), test.GetCurrentBankState());
	}
	
	@Test
	void creditStateTest() {
		BankActions test = new BankActions();
		test.setCreditBankingState();
		assertSame(test.getCreditBankingState(), test.GetCurrentBankState());
		assertNotNull(test.getBankBranch());
	} 

}
