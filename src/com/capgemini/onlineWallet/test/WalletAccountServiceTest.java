package com.capgemini.onlineWallet.test;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.onlineWallet.daoImpl.WalletAccountDaoImp;
import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.model.WalletAccount;

public class WalletAccountServiceTest {
	WalletAccountDaoImp dao;
	
	@Before
	public void setup() {
		dao = new WalletAccountDaoImp();
	}
	
	@Test
	public void testAddAmountToAccountByAccountId_1() {
		int accountId = 1009;
		int userId = 1007;
		double balance = 100.02;
		
		WalletAccount w = new WalletAccount(accountId,userId,balance);
		
		Map<Integer,WalletAccount> store = dao.allAccountDetails();
		store.put(userId,w);
		WalletAccount result = store.get(userId);
		System.out.println(result.getUserId());
		Assert.assertNotNull(result);
		Assert.assertEquals(userId, result.getUserId());
		Assert.assertEquals(accountId, result.getAccountId());
		
		
		
	}
	
	@Test
	public void testAddAmountToAccountByAccountId_2() {
		int accountId = 1009;
		int userId = 1007;
		double balance = 100.02;
		
		WalletAccount w = new WalletAccount(accountId,userId,balance);
		
		Map<Integer,WalletAccount> store = dao.allAccountDetails();
		store.put(userId,w);
		WalletAccount result = store.get(userId);
		System.out.println(result.getUserId());
		Assert.assertNotNull(result);
		Assert.assertEquals(userId, result.getUserId());
		Assert.assertEquals(accountId, result.getAccountId());
		
		
		
	}

}
