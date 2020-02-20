package com.capgemini.onlineWallet.services;

import java.util.List;

import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.WalletTransactions;

public interface WalletTransactionService {

	public void amountTransaction(int senderAccId, int receiverAccId, double balance) throws InsufficientAmount, IncorrectArgumentException;
	List<WalletTransactions> allTransactions(int senderid);
	
}
