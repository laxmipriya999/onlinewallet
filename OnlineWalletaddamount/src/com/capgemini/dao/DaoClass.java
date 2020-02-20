package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import com.capgemini.dao.AccountNotFoundException;

public class DaoClass {

	public ResultSet searchAccount(String accountId) throws AccountNotFoundException,Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DbClass.getConnection1();
		String ins_str = "select * from account where accountId=?";
		pstmt = con.prepareStatement(ins_str);
		pstmt.setString(1, accountId);
		ResultSet accinfo = pstmt.executeQuery();
		if(accinfo.next())
		return accinfo;
		else{
			throw new AccountNotFoundException("Account not valid");
		}

	}

	static int a1 = 0;
	static int a2 = 0;

	public static int deposit(String accountId, int amount) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = DbClass.getConnection1();
		pstmt = con.prepareStatement("select balance from account where accountId=?");
		pstmt.setString(1, accountId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()){
			a1 = amount + rs.getInt(1);
		}
		pstmt = con.prepareStatement("update account set balance=? where accountId=?");
		pstmt.setInt(1, a1);
		pstmt.setString(2, accountId);
		int update = pstmt.executeUpdate();
		if (update > 0) {

			pstmt = con.prepareStatement("select * from account where accountId=?");
			pstmt.setString(1, accountId);
			ResultSet rs1 = pstmt.executeQuery();
			while (rs1.next())
				System.out.println("Name " + rs1.getString(1) + "\nAccount type " + rs1.getString(2) + "\nBalance "
						+ rs1.getInt(3) + "\nPhone " + rs1.getString(4) + "\nCity " + rs1.getString(5) + "\nAccountId "
						+ rs1.getString(6));
		}

		return update;
	}

	static String aid = "9000";
	static int aid2;

	public int addValues(int balance, String name, String type, String phone, String city) throws Exception {
		Connection con = null;
		int x = Math.abs(new Random().nextInt());
		PreparedStatement pstmt = null;

		con = DbClass.getConnection1();
		String ins_str = "insert into account values(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(ins_str);
		pstmt.setString(1, name);
		pstmt.setString(2, type);
		pstmt.setDouble(3, balance);
		pstmt.setString(4, phone);
		pstmt.setString(5, city);
		pstmt.setString(6, Integer.toString(x));
		int updateCount = pstmt.executeUpdate();
		con.close();
		return updateCount;

	}
}
