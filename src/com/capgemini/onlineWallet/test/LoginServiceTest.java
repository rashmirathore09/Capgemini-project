package com.capgemini.onlineWallet.test;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.onlineWallet.daoImpl.LoginDaoImpl;
import com.capgemini.onlineWallet.model.Login;

public class LoginServiceTest {
LoginDaoImpl dao;

@Before
public void setup() {
dao = new LoginDaoImpl();	
}

@Test
 public void testRegisterAccountbyUserId_1() {
	int userId = 106;
	String userName = "Ritik";
	String password = "12345678";
	String phoneNo = "1234512345";
	String loginName = "Ritik1";
	Login l = new Login(userId,userName,password,phoneNo,loginName);
	Map<Integer,Login>store = dao.allUser();
	store.put(userId,l);
	Login result = store.get(userId);
	//System.out.println(result.getUserId());
	Assert.assertNotNull(result);
	Assert.assertEquals(userId, result.getUserId());
	Assert.assertEquals(userName, result.getUserName());
}

/*@Test
public void testRegisterAccountbyUserId_2() {
	int userId = 106;
	String userName = "Ritik";
	String password = "12345678";
	String phoneNo = "1234512345";
	String loginName = "Ritik1";
	Login l = new Login(userId,userName,password,phoneNo,loginName);
	Map<Integer,Login>store = dao.allUser();
	store.put(userId,l);
	Login result = store.get(userId);
	//System.out.println(result.getUserId());
	Assert.assertNotNull(result);
	Assert.assertEquals(userId, result.getUserId());
	Assert.assertEquals("Saket", result.getUserName());
}*/
}
