package Default;

import java.util.Random;

import AccountsFactory.AccountType;

public class User {
	private AccountType accountType;
	private String accountNumber;
	private String[] name;
	private String creditScore;
	private String password;
	
	public User()
	{
		accountNumber = generateAccountNumber();
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
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
		Random random = new Random();
		return Integer.toString(random.nextInt(0) + 9999);
	}
}
