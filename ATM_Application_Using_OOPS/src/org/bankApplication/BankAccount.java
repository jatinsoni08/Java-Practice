package org.bankApplication;

public abstract class BankAccount {
	protected String accountNumber;
	protected String accountHolderName;
	protected double balance;

	public BankAccount(String accountNumber, String accountHolderName, double balance) {

		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public abstract void withdraw(double amount);

	public abstract void deposit(double amount);

	public void displayBalance() {
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Account Holder Name : " + accountHolderName);
		System.out.println("Current Balance : " + balance);
	}
}
