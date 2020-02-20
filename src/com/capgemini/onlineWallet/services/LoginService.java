package com.capgemini.onlineWallet.services;

import com.capgemini.onlineWallet.exceptions.BusinessException;
import com.capgemini.onlineWallet.model.Login;

public interface LoginService {

	public Login loginUser(int userId, String password)throws BusinessException;
	public int addUser(Login login)throws BusinessException;
	public int updatePassword(String oldPassword, 
			String newPassword, String email)throws BusinessException;
}
