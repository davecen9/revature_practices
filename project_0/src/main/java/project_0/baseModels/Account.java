package project_0.baseModels;

import java.util.ArrayList;

import project_0.bankservices.*;

public class Account implements CanCheckBalance, CanDeposit, CanClose{
	
	public static enum accountownershiptype{
		SINGLE,JOINT;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public accounttype getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(accounttype accounttype) {
		this.accounttype = accounttype;
	}


	public static enum accounttype{
		CHECKING,SAVING,CREDIT;
	}
	


	protected accountownershiptype accountownershiptype;
	
	protected int accountid;
	
	protected accounttype accounttype;
	
	protected ArrayList<User> users;
	
	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Double getCreditlimit() {
		return creditlimit;
	}


	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}


	protected Double balance;
	
	protected Double creditlimit;
	
	
	
	
	//general account constructor
	 public Account( accounttype accounttype, accountownershiptype type, User ...user) {
		 this.accountownershiptype = type;
		 this.accounttype = accounttype; 
		 for(User u: user) {
			 this.users.add(u);
		 }
	 }
	
	 
	 public Account( accounttype accounttype, accountownershiptype type, ArrayList<User> userlist) {
		 this.accountownershiptype = type;
		 this.accounttype = accounttype; 
		 this.users = userlist;
	 }
	 
	 public Account(int accountid, accounttype accounttype, accountownershiptype type,Double balance, Double creditlimit, ArrayList<User> userlist) {
		 this.accountid = accountid;
		 this.accountownershiptype = type;
		 this.accounttype = accounttype; 
		 this.balance = balance;
		 this.creditlimit = creditlimit;
		 this.users = userlist;
		 }
	

	 
	 
	
	
	 
	 
	 //general account services
	 public void CheckBalance() {
		 System.out.println("Your account balance is "+ this.balance);
	 }
	 
	 public void Deposit(Double amount) {
		 this.balance += amount;
		 System.out.println("Your new balance is "+ this.balance);
	 }
	 
	 
	 public void Close() {
		 //add method to delete this accountid from the database
		 System.out.println("Account is close");
	 }
	
	 
	 
	//getter and setter methods
	
	public accountownershiptype getAccountownershiptype() {
		return accountownershiptype;
	}


	public void setAccountownershiptype(accountownershiptype accountownershiptype) {
		this.accountownershiptype = accountownershiptype;
	}
	
	







}
