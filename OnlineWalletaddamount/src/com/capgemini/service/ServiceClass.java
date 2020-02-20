package com.capgemini.service;

import java.sql.ResultSet;

import com.capgemini.bean.BeanClass;
import com.capgemini.dao.AccountNotFoundException;
import com.capgemini.dao.DaoClass;

public class ServiceClass {

	@SuppressWarnings("unused")
	public ResultSet searchAccount(String accountId) throws AccountNotFoundException, Exception {
		DaoClass daoclass = new DaoClass();
		ResultSet accResult;
		return accResult = daoclass.searchAccount(accountId);

	}

	@SuppressWarnings("unused")                             
	public int deposit(String accountId, int amount) {
		DaoClass daoclass = new DaoClass();
		int update;
		try {
			update = DaoClass.deposit(accountId, amount);
			return update;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return 0;
		}
	}
	
	public int addValues(String name, String phone, String type, int balance, String city) throws Exception {
		DaoClass daoclass = new DaoClass();
		new BeanClass(name, phone, type, balance, city);
		return daoclass.addValues(balance, name, type, phone, city);

	}
}
