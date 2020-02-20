package com.capgemini.onlineWallet.serviceImpl;

import java.util.List;

import com.capgemini.onlineWallet.daoImpl.WalletAccountDaoImp;
import com.capgemini.onlineWallet.daos.WalletAccountDao;
import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.services.WalletAccountService;

public class WalletAccountServiceImp implements WalletAccountService {
	WalletAccountDao dao = new WalletAccountDaoImp();

	@Override
	public void createWalletAccount(WalletAccount w) {
		// TODO Auto-generated method stub
		dao.createWalletAccount(w);
	}

	@Override
	public void addAmountToAccountByAccountId(int accountId, double balance)
			throws  IncorrectArgumentException {
		// TODO Auto-generated method stub
		List<WalletAccount> list = dao.retriveAllAccount();

		int count = 0;
		if (balance > 0) {
			for (WalletAccount w : list) {
				if (w.getAccountId() == accountId)

				{
					count++;
					dao.addAmountToAccountByAccountId(accountId, balance);
				}
			}
		} else {
			throw new IncorrectArgumentException("Amount can not be in negative");
		}

		if (count == 0) {

			throw new IncorrectArgumentException("AccountId is not valid");

		}

	}

	@Override
	public double showBalanceByAccountid(int accountId) {
		// TODO Auto-generated method stub
		return dao.showBalanceByAccountid(accountId);
	}

	@Override
	public int accountIdOfCurrentUser(int userId) {
		// TODO Auto-generated method stub
		return dao.accountIdOfCurrentUser(userId);
	}

}
