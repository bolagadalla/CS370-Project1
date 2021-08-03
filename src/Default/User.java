package Default;

import AccountsFactory.Account;

public class User {
	private Account accountType;
	private String accountNumber;
	private String[] name;
	private String username;
	private String creditScore;
	private String password;
	
	public User()
	{
		accountNumber = generateAccountNumber();
	}
	
	public Account getAccountType() {
		return accountType;
	}
	public void setAccountType(Account accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String generateAccountNumber()
	{
		return Integer.toString((int)(Math.random()*(9999-0+1)+0));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
