package project_0.pojo;

import java.util.ArrayList;

import project_0.pojo.Account.accountownershiptype;

public abstract class Account {
	
	public enum accountownershiptype{
		SINGLE,JOINT;
	}
	
	public enum accounttype{
		CHECKING,SAVING,CREDIT;
	}
	


	protected accountownershiptype accountownershiptype;
	
	protected String accountid;
	
	protected ArrayList<User> users;
	
	protected String loginid;
	
	protected String loginpassword;
	
	protected accounttype accounttype;
	
	protected Double balance;
	
	protected Double creditlimit;
	
	
	
	
	//general account constructor
	 public Account(accountownershiptype type, String accountid, String loginid, String loginpassword, User ...users) {
		 this.accountownershiptype = type;
		 this.accountid = accountid; //needs to be auto generated
		 this.loginid = loginid;
		 this.loginpassword = loginpassword;
		 for(User u:users) {
			 this.users.add(u);
		 }
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


	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	public String getLoginpassword() {
		return loginpassword;
	}


	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
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
