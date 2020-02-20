package com.capgemini.dao;
import java.sql.*;

public class DbClass {
	public static Connection getConnection1() throws Exception {

		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "laxmi", "priya");

		return conn;
	}

}

 