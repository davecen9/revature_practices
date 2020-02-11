package project_0.accounts;

import java.util.ArrayList;

import project_0.baseModels.Account;
import project_0.baseModels.User;
import project_0.baseModels.Account.accountownershiptype;
import project_0.baseModels.Account.accounttype;


public class CreditAccount extends Account{
	
	private int accountid = 0;
	private accounttype accounttype = Account.accounttype.CREDIT;
	private Double creditlimit = 1000.0;
	private Double balance = 0.0;
	
	
	public CreditAccount(int accountid, accounttype accounttype, accountownershiptype type,Double balance, Double creditlimit, ArrayList<User> userlist) {
		 super(accountid, accounttype, type, balance, creditlimit,userlist);

		 }
	
	
	public CreditAccount( accounttype accounttype,accountownershiptype type, ArrayList<User> userlist) {
		 super( accounttype,type, userlist);
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


	public Double getCreditlimit() {
		return creditlimit;
	}


	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}



	
	
}
