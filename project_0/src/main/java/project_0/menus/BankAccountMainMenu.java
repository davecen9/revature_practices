package project_0.menus;
import java.io.*;
import java.util.ArrayList;

import project_0.accounts.CheckingAccount;
import project_0.accounts.CreditAccount;
import project_0.accounts.SavingAccount;
import project_0.baseModels.*;
import project_0.utils.ConnectionUtil;
import project_0.utils.InputCheckUtil;
import project_0.DAO.*;


public class BankAccountMainMenu {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static int selection;
	public static void main(String[] args) {
//		User user = new User("davecen9","fanliang","cen","294597053","294597053");//testing value
//		checkingAccCreation(user);//testing value
		}
		

	public static Account checkingAccCreation(User user) {
		System.out.println("Checking account allows you to perform daily transactions such as deposit"+
	     ", withdraw and transfer money, please follow the instructions below to create your checking"+
				" account. Press 0 anytime to go back");
		Account.accounttype accounttype = Account.accounttype.CHECKING;
		Account.accountownershiptype accountownershiptype = Account.accountownershiptype.SINGLE;

		ArrayList<User> userlist = new ArrayList<User>();
		userlist.add(user);
		
		
		System.out.println();
	
				System.out.println("Do you want a 1.SINGLE or 2.JOINT account? Please enter 1 or 2...");
				
				int selection = InputCheckUtil.getInteger(0,2);
				
				if(selection ==1) {
					System.out.println("Alright, you are creating a SINGLE account!");
				}
				else if (selection ==2) {
					System.out.println("Alright, you are creating a JOINT account!");
					accountownershiptype = Account.accountownershiptype.JOINT;
					userlist = getUserlist(user);
				}
				else if (selection ==0) {
					UserLoginMenu.createBankAccount(user);
				}
	


		Account account = new CheckingAccount(accounttype, accountownershiptype, userlist);

		account = AccountDAO.createAccount(user, account);

		return account;
	}
	
	
	
	
	public static Account creditAccCreation(User user) {
		System.out.println("Credit account allows you to shop now and pay back later! "
				+ "Default credit limit is $1000.");
		Account.accounttype accounttype = Account.accounttype.CREDIT;
		Account.accountownershiptype accountownershiptype = Account.accountownershiptype.SINGLE;

		ArrayList<User> userlist = new ArrayList<User>();
		userlist.add(user);
		
		
		System.out.println();
	
				System.out.println("Do you want a 1.SINGLE or 2.JOINT account? Please enter 1 or 2...");
				
				int selection = InputCheckUtil.getInteger(0,2);
				
				if(selection ==1) {
					System.out.println("Alright, you are creating a SINGLE account!");
				}
				else if (selection ==2) {
					System.out.println("Alright, you are creating a JOINT account!");
					accountownershiptype = Account.accountownershiptype.JOINT;
					userlist = getUserlist(user);
				}
				else if (selection ==0) {
					UserLoginMenu.createBankAccount(user);
				}
	


		Account account = new CreditAccount(accounttype, accountownershiptype, userlist);

		account = AccountDAO.createAccount(user, account);

		return account;
	}
	
	
	
	
	public static Account savingAccCreation(User user) {
		System.out.println("Saving account allows you to earn interest while putting money in the bank, "+
	"minimum balance is $5000");
		Account.accounttype accounttype = Account.accounttype.SAVING;
		Account.accountownershiptype accountownershiptype = Account.accountownershiptype.SINGLE;

		ArrayList<User> userlist = new ArrayList<User>();
		userlist.add(user);
		
		
		System.out.println();
	
				System.out.println("Do you want a 1.SINGLE or 2.JOINT account? Please enter 1 or 2...");
				
				int selection = InputCheckUtil.getInteger(0,2);
				
				if(selection ==1) {
					System.out.println("Alright, you are creating a SINGLE account!");
				}
				else if (selection ==2) {
					System.out.println("Alright, you are creating a JOINT account!");
					accountownershiptype = Account.accountownershiptype.JOINT;
					userlist = getUserlist(user);
				}
				else if (selection ==0) {
					UserLoginMenu.createBankAccount(user);
				}
	


		Account account = new SavingAccount(accounttype, accountownershiptype, userlist);

		account = AccountDAO.createAccount(user, account);

		return account;
	}

	
	public static ArrayList<User> getUserlist(User user){
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<User> userlist = new ArrayList<User>();
		String username = null;
		userlist.add(user);
		
		while(true) {
			System.out.println("Who else do you want to add into this bank account? Please enter "+
			"their username, enter \"done\" when you are done");
			
			
				username = InputCheckUtil.getString();
				if(!username.equals("done")) {
					list.add(username); 
				}
				else {
					break;
				}
		}
				
			
			
			for(String s: list) {
				if(UserDao.varifyuser(s) == false) {
					System.out.println("User id " + username+" doesn't exist!");
					
				}
				else {
					userlist.add(UserDao.getUser(s));
				}
			}
		return userlist;
	
	}
	
		
	

}

