package com.capgemini.onlineWallet.util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

		public class DbUtil {
			private static Connection con;
			public static Connection createConnection(){
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rashmi","rathore");
					
				}catch(SQLException e)
				{
					System.out.println("Sql exception");
				}catch(Exception g)
				{
					g.printStackTrace();
			 }
				return con;
			}
			
			public static void closeConnection() {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		}


