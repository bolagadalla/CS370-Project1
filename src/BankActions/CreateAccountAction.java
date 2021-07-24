package BankActions;

import java.util.Scanner;

import AccountsFactory.CreditCard;
import AccountsFactory.DebitCard;
import Default.Actions;
import Default.Bank;
import Default.User;

public class CreateAccountAction implements Actions {
	
	User newUser = new User();
	
	@Override
	public boolean Check() {
		Bank.getInstance();
		// TODO Auto-generated method stub
		return !Bank.checkUserExist(newUser.getAccountNumber());
	}

	@Override
	public void Action() {
		// Takes user input and add it to the new user Object
		AskForUserInfo();
		// Checks if the user actually exists
		if (!Check()) return;
		// If it doesnt exit then it will continue to here
		// We add the new user to the bank and make them the currentUserUsingBank
		Bank.AddNewUser(newUser.getAccountNumber(), newUser);
	}
	
	public void AskForUserInfo()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like to open?");
		System.out.println("1) Checking Account");
		System.out.println("2) Credit Account");
		int accountType = scan.nextInt();
		
		switch (accountType) {
		case 1: {
			System.out.println("What would be your initial deposit");
			double initialAmount = scan.nextDouble();
			newUser.setAccountType(new DebitCard(initialAmount));
		}
		case 2: {
			System.out.println("What is your current Credit Score?");
			int creditScore = scan.nextInt();
			newUser.setAccountType(new CreditCard(CalculateCreditLimitAmount(creditScore)));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
	}
	
	public double CalculateCreditLimitAmount(int creditScore)
	{
		// equation: (creditScore * 3) - maximumSubtractionFromCreditLimit %
		int maximumSubtractionFromCreditLimit = 65; // 65%

		if (creditScore >= 300 && creditScore <= 500) {
			maximumSubtractionFromCreditLimit -= 20;
		}
		else if (creditScore > 500 && creditScore <= 700) {
			maximumSubtractionFromCreditLimit -= 40;
		}
		else if (creditScore > 700 && creditScore <= 800) {
			maximumSubtractionFromCreditLimit -= 65;
		}
		
		return (creditScore * 3) - ((creditScore * 3) * (maximumSubtractionFromCreditLimit / 100));
	}
}
