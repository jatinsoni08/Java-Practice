package org.bankApplication;

public class ATM {
	static int totalTransaction;

	static {
		totalTransaction = 0;
		System.out.println("ATM System Initiated");
	}

	public static void performTransaction(BankAccount account, String type, double amount) {
		switch (type.toLowerCase()) {
		case "withdraw":
			account.withdraw(amount);
			totalTransaction++;
			break;

		case "deposit":
			account.deposit(amount);
			totalTransaction++;
			break;
		default:
			System.out.println("Invalid Transaction Type");
		}
	}

}
