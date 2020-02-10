package project_0.menus;
import java.io.*;
import java.util.ArrayList;

import project_0.accounts.CheckingAccount;
import project_0.baseModels.*;
import project_0.utils.InputCheckUtil;
import project_0.DAO.*;


public class BankAccountMainMenu {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static int selection;
	public static void main(String[] args) {
		User user = new User("davecen9","fanliang","cen","294597053","294597053");//testing value
		checkingAccCreation(user);//testing value
		}
		
	
	public static void bankAccountMenu(User u) {
		
		System.out.println("What type of account do you need ?");
		System.out.println();
		System.out.println("#Press 1 for a Checking account");
		System.out.println();
		System.out.println("#Press 2 for a Credit account");
		System.out.println();
		System.out.println("#Press 3 for a Saving account");
		System.out.println();
		System.out.println("#Press 0 to go back");
		
		selection = InputCheckUtil.getInteger(0,3);
		switch (selection) {
		case 0: System.out.println("nothing");
		case 1: checkingAccCreation(u);
		case 2: System.out.println("nothing");
		case 3: System.out.println("nothing");
		}
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
					userlist = getUserlist();
				}
				else if (selection ==0) {
					bankAccountMenu(user);
				}
	


		Account account = new CheckingAccount(accounttype, accountownershiptype, userlist);
		System.out.println("local account created");
		account = AccountDAO.createAccount(account);
		System.out.println("remote account created");
		return account;
	}
	

	
	public static ArrayList<User> getUserlist(){
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<User> userlist = new ArrayList<User>();
		String username = null;
		
		while(true) {
			System.out.println("Who else do you want to add into this bank account? Please enter "+
			"their username, enter \"done\" when you are done");
			
			do {
				username = InputCheckUtil.getString();
				list.add(username); 
				}
			while(!username.equals("done"));
			
			
			for(String s: list) {
				if(UserDao.varifyuser(s) == false) {
					System.out.println("User id " + username+" doesn't exist!");
					
				}
				else {
					userlist.add(UserDao.getUser(s));
				}
				
			}
			break;
		}
		
		return userlist;
	}
		
	
	
		
	
	public static void listAccounts(User user){
		
	
	}
}

