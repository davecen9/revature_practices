package project_0.baseModels;

import java.util.ArrayList;

import project_0.bankservices.*;

public class Account implements CanCheckBalance, CanDeposit, CanClose{
	
	public static enum accountownershiptype{
		SINGLE,JOINT;
	}
	
	public static enum accounttype{
		CHECKING,SAVING,CREDIT;
	}
	


	protected accountownershiptype accountownershiptype;
	
	protected String accountid;
	protected accounttype accounttype;
	
	protected ArrayList<User> users;
	
	protected Double balance;
	
	protected Double creditlimit;
	
	
	
	
	//general account constructor
	 public Account( accounttype accounttype, accountownershiptype type,User ...users) {
		 this.accountownershiptype = type;
		 this.accounttype = accounttype; 
		 for(User u:users) {
			 this.users.add(u);
		 }
	 }
	
	 
	 public Account( String accountid, accounttype accounttype, accountownershiptype type,Double balance, Double creditlimit, ArrayList<User> userlist) {
		 this.accountownershiptype = type;
		 this.accounttype = accounttype; 
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
	
	
	public ArrayList<User> getUsers() {
		return users;
		}
		
	
	public void setUsers(User ...users) {
		for(User u : users) {
			this.users.add(u);
		}
		
	}
	
	public String getAccountid() {
		return accountid;
	}


	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}



	public accounttype getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(accounttype accounttype) {
		this.accounttype = accounttype;
	}


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


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}



}
