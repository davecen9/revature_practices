package project_0.pojo;

import java.util.ArrayList;

public abstract class Accounts {
	
	public enum accountownershiptype{
		SINGLE,JOINT;
	}
	
	public enum accounttype{
		CHECKING,SAVING,CREDIT;
	}
	

	



	protected accountownershiptype accountownershiptype;
	
	protected Integer accountid;
	
	protected ArrayList<Users> users;
	
	protected String loginid;
	
	protected Integer loginpassword;
	
	protected accounttype accounttype;
	
	protected Integer balance;
	
	protected Integer creditlimit;
	
	
	
	public accountownershiptype getAccountownershiptype() {
		return accountownershiptype;
	}


	public void setAccountownershiptype(accountownershiptype accountownershiptype) {
		this.accountownershiptype = accountownershiptype;
	}
	
	
	public ArrayList<Users> getUsers() {
		return users;
		}
		
	
	public void setUsers(Users ...users) {
		for(Users u : users) {
			this.users.add(u);
		}
		
	}
	
	public Integer getAccountid() {
		return accountid;
	}


	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}


	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	public Integer getLoginpassword() {
		return loginpassword;
	}


	public void setLoginpassword(Integer loginpassword) {
		this.loginpassword = loginpassword;
	}


	public accounttype getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(accounttype accounttype) {
		this.accounttype = accounttype;
	}


	public Integer getBalance() {
		return balance;
	}


	public Accounts(project_0.pojo.Accounts.accountownershiptype accountownershiptype, Integer accountid,
			ArrayList<Users> users, String loginid, Integer loginpassword,
			project_0.pojo.Accounts.accounttype accounttype, Integer balance, Integer creditlimit) {
		super();
		this.accountownershiptype = accountownershiptype;
		this.accountid = accountid;
		this.users = users;
		this.loginid = loginid;
		this.loginpassword = loginpassword;
		this.accounttype = accounttype;
		this.balance = balance;
		this.creditlimit = creditlimit;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public Integer getCreditlimit() {
		return creditlimit;
	}


	public void setCreditlimit(Integer creditlimit) {
		this.creditlimit = creditlimit;
	}


	public void setUsers(ArrayList<Users> users) {
		this.users = users;
	}



}
