package org.bankApplication;

public class SavingsAccount extends BankAccount {

	private static final double MIN_BALANCE = 500;

	public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
		super(accountNumber, accountHolderName, balance);
	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount >= MIN_BALANCE) {
			balance = balance - amount;
			System.out.println("Withdrwal Amount of " + amount + " is Successfull");
		} else {
			System.out.println("Insufficient Funds");
		}
	}

	@Override
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Deposited " + balance + " in Your Account");

	}

}
