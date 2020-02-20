package com.capgemini.pl;

import java.sql.ResultSet;
import java.util.Scanner;
import com.capgemini.dao.AccountNotFoundException;
import com.capgemini.service.ServiceClass;

public class MainUI {
	static ServiceClass accService = new ServiceClass();

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		String city = "";
		String type = "";
		String name = "";
		String phone = "";
		int balance = 0;
		int a = 0;
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("1.create account");
			System.out.println("2.deposit");
			System.out.println("3.exit");
			a = s.nextInt();
			String accountId;

			switch (a) {

			case 1:
				System.out.println("Name should be in characters");
				name = s.next();
				while (!(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
					System.out.println("First letter should be in capitals");
					name = s.next();
				}
				System.out.println("Enter BALANCE");
				balance = s.nextInt();
				System.out.println("ENTER TYPE");
				type = s.next();
				while (!(type.equalsIgnoreCase("current") || type.equalsIgnoreCase("savings"))) {
					System.out.println("Account should be current or savings");
					type = s.next();
				}

				System.out.println("ENTER phone number");
				phone = s.next();
				while (!(phone.length() == 10 && (phone.charAt(0) == '6') || (phone.charAt(0) == '7')
						|| (phone.charAt(0) == '8') || (phone.charAt(0) == '9'))) {
					System.out.println("Phone number length should be 10 and should start with6 or 7 or 8 or 9");
					phone = s.next();
				}
				System.out.println("ENTER city");
				city = s.next();
				int updateCount = accService.addValues(name, phone, type, balance, city);
				System.out.println("Inserted " + updateCount + " record");
				break;
			
			case 2:
				try{
				System.out.println("enter account id");
				accountId = s.next();
				ResultSet accinfo = accService.searchAccount(accountId);
				System.out.println("Enter amount");
				int amount = s.nextInt();
				int updated = accService.deposit(accountId, amount);
				if (updated > 0) {
					System.out.println("Deposited");
					
				} else
					System.out.println("Not Deposited");
				
			} 
			catch (AccountNotFoundException e) {
				System.out.println("Account Id does not exist");
				System.out.println("enter account id");
				accountId = s.next();
				ResultSet accinfo = accService.searchAccount(accountId);
				System.out.println("Enter amount");
				int amount = s.nextInt();
				int updated = accService.deposit(accountId, amount);
				if (updated > 0) {
					System.out.println("Deposited");
					
				} else
					System.out.println("Not Deposited");
			}
			
				break;
				
				
		case 3:
			System.out.println("thank you for visiting");
			System.exit(0);
					
			}
		}
	}}


