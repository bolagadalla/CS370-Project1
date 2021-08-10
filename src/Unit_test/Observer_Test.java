package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import Observers.Logger;

class ObserverTest {

	@Test
	void testUpdate() {
		
		Logger logger = new Logger();
		logger.update("testing by test function", "Test");
		
		String testLog = logger.getStackLog("Test").pop();
		assertTrue(testLog.equalsIgnoreCase("testing by test function -- " + LocalDateTime.now().toString().substring(0,19)));
	}
	
}
