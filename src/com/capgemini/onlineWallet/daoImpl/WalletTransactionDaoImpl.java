package com.capgemini.onlineWallet.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.onlineWallet.daos.WalletTransactionDao;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.model.WalletTransactions;
import com.capgemini.onlineWallet.util.DbUtil;

public class WalletTransactionDaoImpl implements WalletTransactionDao{

	static Map<Integer,WalletTransactions> store = new HashMap<>();
	/*
	 * @method amountTransaction with ar
	 */
	@Override
	public void amountTransaction(int senderId, int receiverId, double balance) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.createConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("update WalletAccount set accountbalance=accountbalance-? where userId=?");
			ps.setDouble(1, balance);
			ps.setInt(2,senderId);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
		try {
			PreparedStatement ps=con.prepareStatement("update WalletAccount set accountbalance=accountbalance+? where userId=?");
			ps.setDouble(1, balance);
			ps.setInt(2,receiverId);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement stat=con.createStatement();			
			ResultSet rs=stat.executeQuery("select transactionIdIncrement.NEXTVAL from dual");
			rs.next();
			
			int transactionid=(int)rs.getLong(1);
			
			String sql ="insert into walletTransactions values(?,?,CURRENT_TIMESTAMP,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			WalletTransactions t=new WalletTransactions();
			ps.setInt(1, transactionid);
			ps.setString(2, "Sended");
			ps.setDouble(3, balance);
			ps.setInt(4, senderId);
			ps.setInt(5,receiverId);
			ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
				DbUtil.closeConnection();
		
		
	}

	@Override
	public List<WalletTransactions> allTransactions(int senderid) {
		Connection con= DbUtil.createConnection();
		WalletTransactions w =null;
		 List<WalletTransactions> list = new ArrayList<>();
		try
		{ 
			String sql="Select * from WalletTransactions where senderid=?";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, senderid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				w=new WalletTransactions();
				w.setDescription(rs.getString(2));
				w.setAmount(rs.getDouble(4));

				w.setReceiverAccId(rs.getInt(6));
				w.setDateOfTransaction(rs.getDate(3));
				list.add(w);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<WalletAccount> retriveAllAccount() {
		List<WalletAccount> accounts=new ArrayList<>();
		try {
			Connection con = DbUtil.createConnection();
			String sql="select * from walletAccount";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				WalletAccount w=new WalletAccount();
				w.setAccountId(rs.getInt(1));
				w.setUserId(rs.getInt(2));
				w.setAccountBalance(rs.getDouble(3));
				accounts.add(w);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public Map<Integer,WalletTransactions> allTransactionDetails(){
		
		try {
			Connection con = DbUtil.createConnection();
			String sql="select * from walletTransactions";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				WalletTransactions w=new WalletTransactions();
				w.setDescription(rs.getString(2));
				w.setDateOfTransaction(rs.getDate(3));
				w.setAmount(rs.getDouble(4));
				w.setReceiverAccId(rs.getInt(5));
				store.put(w.getReceiverAccId(),w);
				//System.out.println(w.getAccountBalance());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return store;
		
	}

	

}
