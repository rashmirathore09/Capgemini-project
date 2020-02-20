package com.capgemini.onlineWallet.test;


import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.onlineWallet.daoImpl.WalletTransactionDaoImpl;
import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.model.WalletTransactions;

public class WalletTransactionsServiceTest {
	WalletTransactionDaoImpl dao;
	
	@Before
	public void setup() {
		dao = new WalletTransactionDaoImpl();
	}
/*
 * @method amountTransation test the amountTransaction method of
 * WalletTransaction service implementation;	
 */
	@Test
	public void amountTransaction_1() {
		String desc = "Sended";
		double amount = 100.25;
		Date date = new java.util.Date();
		int receiverId = 1006;
		double balance=50.0;
		
		WalletTransactions w = new WalletTransactions(receiverId,desc,date,amount,balance);
		Map<Integer,WalletTransactions>store = dao.allTransactionDetails();
		store.put(receiverId, w);
		WalletTransactions result = store.get(receiverId);
		Assert.assertNotNull(result);
		Assert.assertEquals(receiverId, result.getReceiverAccId());
		
	}
}
