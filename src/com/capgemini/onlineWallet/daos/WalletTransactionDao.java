package com.capgemini.onlineWallet.daos;

import java.util.List;
import java.util.Map;

import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.model.WalletTransactions;

public interface WalletTransactionDao {
	public void amountTransaction(int senderAccId, int receiverAccId, double balance);
	  List<WalletTransactions> allTransactions(int senderid);
	  public List<WalletAccount> retriveAllAccount(); 
	  public Map<Integer,WalletTransactions> allTransactionDetails();
	  
}
