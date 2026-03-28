package org.bankApplication;

public class BankDriver {
	public static void main(String[] args) {
		BankAccount ba = new SavingsAccount("9636559", "Jatin", 1000);
		
		ATM.performTransaction(ba, "withdraw", 200);
		
		ba.displayBalance();
		
		System.out.println("====================");
		
		ATM.performTransaction(ba, "deposit", 1000);
		
		ba.displayBalance();
		
		System.out.println("====================");

		
		System.out.println("Total Transacrtion  :" + ATM.totalTransaction);

		
		
	}
}
