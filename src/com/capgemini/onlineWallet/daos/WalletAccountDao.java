package com.capgemini.onlineWallet.daos;

import java.util.List;
import java.util.Map;

import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.model.WalletAccount;

public interface WalletAccountDao {
	void createWalletAccount(WalletAccount w);

	void addAmountToAccountByAccountId(int accountId, double balance);

	
	double showBalanceByAccountid(int accountId);
	int accountIdOfCurrentUser(int userId);
	List<WalletAccount> allAccount();
	
	public List<WalletAccount> retriveAllAccount();
	public Map<Integer,WalletAccount> allAccountDetails();

}
