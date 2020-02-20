package com.capgemini.onlineWallet.services;

import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.WalletAccount;

public interface WalletAccountService {
	void createWalletAccount(WalletAccount w);
	void addAmountToAccountByAccountId(int  accountId,double balance) throws InsufficientAmount, IncorrectArgumentException;
	double showBalanceByAccountid(int accountId);
	int accountIdOfCurrentUser(int userId);
}
