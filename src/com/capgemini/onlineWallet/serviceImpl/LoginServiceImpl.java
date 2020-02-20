package com.capgemini.onlineWallet.serviceImpl;

import com.capgemini.onlineWallet.exceptions.BusinessException;
import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.services.LoginService;
import com.capgemini.onlineWallet.daoImpl.LoginDaoImpl;
import com.capgemini.onlineWallet.daos.LoginDao;

public class LoginServiceImpl implements LoginService{
	
	LoginDao loginDao=null;
	
	public LoginServiceImpl() {
		loginDao=new LoginDaoImpl();
	}
	
	@Override
	public Login loginUser(int userId, String password) throws BusinessException {
		return loginDao.loginUser(userId, password);
	}

	
	@Override
	public int addUser(Login login) throws BusinessException {
		// TODO Auto-generated method stub
		
			if(login.getUserName() != null) {
				if(login.getPassword()!=null &&
						login.getPassword().matches("[a-zA-Z0-9]{8,}")) {
					if(login.getPhoneNumber().matches("(0/91)?[7-9][0-9]{9}")) {
					return loginDao.registerUser(login);
					}
					else {
						throw new BusinessException("PhoneNo is not valid");
					}
					}else {
					throw new BusinessException("password length should be 8 or more then 8");
				}
			}else {
				throw new BusinessException("UserName can not be empty");
			}
		
		
		
	}

	@Override
	public int updatePassword(String oldPassword, String newPassword, String email) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
