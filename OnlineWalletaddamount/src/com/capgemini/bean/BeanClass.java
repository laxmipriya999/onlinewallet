package com.capgemini.bean;
import java.io.Serializable;

@SuppressWarnings("serial")
public class BeanClass implements Serializable{

	private String city="";
	private String type="";
	private String name = "";
	private String phone = "";
	private int balance = 0;
	private int accountid=0;
	
	public BeanClass(String city, String type, String name, int balance, String phone) {
		super();
		this.city = city;
		this.type = type;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

}
