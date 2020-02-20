package com.capgemini.onlineWallet.model;

import java.util.Date;

public class WalletTransactions {
	
	int receiverAccId;
	String description;
	Date dateOfTransaction;
	double amount;
	double accountBalance;
	
	
	
	
	public WalletTransactions() {
	
	}
	
	

	public WalletTransactions(int receiverAccId, String description, Date dateOfTransaction, double amount,
			double accountBalance) {
		this.receiverAccId = receiverAccId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}



	public int getReceiverAccId() {
		return receiverAccId;
	}




	public void setReceiverAccId(int receiverAccId) {
		this.receiverAccId = receiverAccId;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}




	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public double getAccountBalance() {
		return accountBalance;
	}




	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}




	
	
}
