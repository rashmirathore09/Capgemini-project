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

import com.capgemini.onlineWallet.daos.WalletAccountDao;
import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.model.WalletAccount;
import com.capgemini.onlineWallet.util.DbUtil;

public class WalletAccountDaoImp implements WalletAccountDao{
	static Map<Integer,WalletAccount> store = new HashMap<>();
	@Override
	public void createWalletAccount(WalletAccount w) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.createConnection();
		try {
			
			Statement stat=con.createStatement();			
			ResultSet rs=stat.executeQuery("select userIdIncrement.NEXTVAL from dual");
			rs.next();
			int accountId=(int)rs.getLong(1);
			
			String sql = "Insert into walletAccount(accountId, userId,accountBalance)"+"values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,accountId);
			ps.setInt(2,w.getUserId());
			ps.setDouble(3, w.getAccountBalance());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.closeConnection();
		
	}

	@Override
	public void addAmountToAccountByAccountId(int accountId, double balance) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update WalletAccount set accountbalance=accountbalance+? where accountId=?");
			ps.setDouble(1, balance);
			ps.setInt(2,accountId);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.closeConnection();
		
	}

	@Override
	public double showBalanceByAccountid(int accountId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.createConnection();
		WalletAccount 	w = new WalletAccount();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from walletaccount where accountId=?");
			ps.setInt(1, accountId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				w.setAccountBalance(rs.getDouble(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DbUtil.closeConnection();
		return w.getAccountBalance();
		
	}

	@Override
	public List<WalletAccount> allAccount() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int accountIdOfCurrentUser(int userId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.createConnection();
		int accountId=0;
		
		try {
			PreparedStatement ps=con.prepareStatement("Select * from walletaccount where userId=?");
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accountId = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accountId;
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
	public Map<Integer,WalletAccount> allAccountDetails(){
		
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
				store.put(w.getUserId(),w);
				//System.out.println(l.getUserId());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return store;
		
		
		
	}
	

}
