package com.capgemini.onlineWallet.serviceImpl;

import java.util.List;

import com.capgemini.onlineWallet.daoImpl.WalletTransactionDaoImpl;
import com.capgemini.onlineWallet.daos.WalletTransactionDao;
import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.model.WalletTransactions;
import com.capgemini.onlineWallet.services.WalletTransactionService;

public class WalletTransactionServiceImpl implements WalletTransactionService {

	WalletTransactionDao dao = new WalletTransactionDaoImpl();
	
	/*
	 * @method amountTransaction with senderid,receiverid,amount transfered
	 * @ throw exception Insufficient balance and IncorrectArgumentExption
	 */
	@Override
	public void amountTransaction(int senderId, int receiverId, double balance) throws InsufficientAmount, IncorrectArgumentException {
		// TODO Auto-generated method stub
		List<WalletAccount> list = dao.retriveAllAccount();
		int count = 0;
		if(balance>0) {
			for (WalletAccount w : list) {
			if (w.getUserId() == receiverId)

				{
					count++;
					dao.amountTransaction(senderId, receiverId, balance);
				}
			}
		}else
		{
			throw new InsufficientAmount("amount is invalid");
		}
		
		
	   if (count == 0) {

			throw new IncorrectArgumentException("AccountId is not valid");

		}
	}	
		
	/*
	 * @method allTransactions with argument senderid
	 * return list of all transactions done by a sender;
	 */
	
	@Override
	public List<WalletTransactions> allTransactions(int senderid) {
		// TODO Auto-generated method stub
		return dao.allTransactions(senderid);
	}
}
