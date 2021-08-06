package Default;

import AccountsFactory.Account;
import Proxy.Pin;

public class User {
	private Account accountType;
	private String[] name;
	private String username;
	private String creditScore;
	private String ssn;
	private Pin pin;
	

	public Account getAccountType() {
		return accountType;
	}
	public void setAccountType(Account accountType) {
		this.accountType = accountType;
	}
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String ssn) {
		this.creditScore = ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	public Pin getPin() {
		return pin;
	}
	public void setPin(Pin pin) {
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "Account Type:\t" + accountType.toString() + "\nUsername:\t" + username + "\nPin:\t" + pin.getPinNum();
	}
}
