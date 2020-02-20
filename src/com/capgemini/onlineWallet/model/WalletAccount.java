 package com.capgemini.onlineWallet.model;

public class WalletAccount {

	int userId;
	int accountId;
	double accountBalance;
	
	
	public WalletAccount() {
	
	}
	
	public WalletAccount(int accountId, int userId, double accountBalance) {
		this.accountId = accountId;
		this.userId = userId;
		this.accountBalance = accountBalance;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
