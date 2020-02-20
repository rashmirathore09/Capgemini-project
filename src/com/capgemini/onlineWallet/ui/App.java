package com.capgemini.onlineWallet.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.onlineWallet.exceptions.BusinessException;
import com.capgemini.onlineWallet.exceptions.IncorrectArgumentException;
import com.capgemini.onlineWallet.exceptions.InsufficientAmount;
import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.model.WalletTransactions;
import com.capgemini.onlineWallet.serviceImpl.LoginServiceImpl;
import com.capgemini.onlineWallet.serviceImpl.WalletAccountServiceImp;
import com.capgemini.onlineWallet.serviceImpl.WalletTransactionServiceImpl;
import com.capgemini.onlineWallet.services.LoginService;
import com.capgemini.onlineWallet.services.WalletAccountService;
import com.capgemini.onlineWallet.services.WalletTransactionService;

public class App {

	public static void main(String[] args) throws BusinessException, InsufficientAmount, IncorrectArgumentException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		App t = new App();
		do {
		System.out.println("Welcome to Online Wallet");

		System.out.println("1. Login\n2. Register\n3. Termination");

		int choice = sc.nextInt();
		{
			switch (choice) {

			case 1: {
				System.out.println("Login Page");
				t.loginUser();
				break;
			}

			case 2: {
				System.out.println("Register Page");
				t.registerUser();
				break;
			}

			case 3:
				System.out.println("Successfully Terminated");
				System.exit(0);
			}

		}
	}while(true);

	}
	
	// Login Method
	public void loginUser() throws InsufficientAmount, IncorrectArgumentException {
		LoginService lService = new LoginServiceImpl();
		Login login = new Login();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your UserId: ");
		int userId = sc.nextInt();

		System.out.println("Enter your Password: ");
		String password = sc.next();

		try {
			login = lService.loginUser(userId, password);
		} catch (BusinessException e) {
			System.out.println("exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(login.getUserName());
		if (login.getUserId() == userId && login.getPassword().equals(password)) {

			WalletAccountService serviceAmount = new WalletAccountServiceImp();
			WalletTransactionService serviceTransaction = new WalletTransactionServiceImpl();
			int accountId = serviceAmount.accountIdOfCurrentUser(userId);

			while (true) {
				System.out.println(
						"1. Add Balance\n2. Show Balance\n3. Transfer Balance\n4.Transaction History\n5. Exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("----------Add Balance-----------");
					System.out.println("Enter Amount");
					double amount = sc.nextDouble();
					// System.out.println("Enter your AccountId");
					// int accountId = sc.nextInt();
					serviceAmount.addAmountToAccountByAccountId(accountId, amount);
					break;
				}

				case 2: {
					System.out.println("------------Show Balance----------");

					System.out.println("Current Balance: " + serviceAmount.showBalanceByAccountid(accountId));

					break;
				}

				case 3: {
					System.out.println("---------Transfer Balance----------");
					System.out.println("Enter Receiver AccountId");
					int receiverAccId = sc.nextInt();
					System.out.println("Enter Transfer Amount");
					double balance = sc.nextDouble();

					serviceTransaction.amountTransaction(userId, receiverAccId, balance);
					System.out.println("Balance Transfered:");
					break;
				}

				case 4: {
					System.out.println("Transaction History");
					List<WalletTransactions> list = new ArrayList<>();
					list = serviceTransaction.allTransactions(userId);
					for (WalletTransactions w : list) {
						System.out.println("sender id= " + userId + "receiverid= " + w.getReceiverAccId() + "date="
								+ w.getDateOfTransaction()+"balance"+w.getAmount());
					}
					break;
				}
				case 5:
					System.exit(0);
				}
			}
		} else {
			System.out.println("Given Data is not Correct. Please provide correct data");
		}
	}

	// Register User
	public void registerUser() {

		LoginService lService = new LoginServiceImpl();
		WalletAccountService accountService = new WalletAccountServiceImp();
		WalletAccountService serviceAmount = new WalletAccountServiceImp();

		Login login = new Login();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the user Name");
		login.setUserName(sc.next());

		System.out.println("Enter the password");
		login.setPassword(sc.next());

		System.out.println("Enter the phone Number");
		login.setPhoneNumber(sc.next());

		System.out.println("Enter the login Name");
		login.setLoginName(sc.next());

		try {

			int userId = lService.addUser(login);
			System.out.println("registered Sucess");
			System.out.println("Your user id is="+userId);

			WalletAccount w = new WalletAccount();
			w.setUserId(userId);

			w.setAccountId(serviceAmount.accountIdOfCurrentUser(userId));
			w.setAccountBalance(0.0);

			accountService.createWalletAccount(w);
			System.out.println("Wallet Created");

		} catch (BusinessException e) {

			System.out.println(e.getMessage());

		}

	}

}
