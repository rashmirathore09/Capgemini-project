package com.capgemini.onlineWallet.daos;

import java.util.Map;
import java.util.Set;

import com.capgemini.onlineWallet.model.Login;

public interface LoginDao {

	public Login loginUser(int userId, String pass); 
	public int registerUser(Login login);
	public int changePassword(String oldPassword, String newPassword, String email);
	public Map<Integer,Login> allUser();
}

