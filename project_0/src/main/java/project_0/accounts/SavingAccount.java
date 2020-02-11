package project_0.accounts;

import java.util.ArrayList;

import project_0.baseModels.Account;
import project_0.baseModels.User;
import project_0.baseModels.Account.accountownershiptype;
import project_0.baseModels.Account.accounttype;


public class SavingAccount extends Account{
	private int accountid = 0;
	private accounttype accountype = Account.accounttype.SAVING;
	private Double creditlimit = 0.0;
	private Double balance = 5000.0;


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public accounttype getAccountype() {
		return accountype;
	}


	public void setAccountype(accounttype accountype) {
		this.accountype = accountype;
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
	
	
	
	
	public SavingAccount(int accountid, accounttype accounttype, accountownershiptype type,Double balance, Double creditlimit, ArrayList<User> userlist) {
		 super(accountid, accounttype, type, balance, creditlimit,userlist);

		 }
	
	
	public SavingAccount( accounttype accounttype,accountownershiptype type, ArrayList<User> userlist) {
		 super( accounttype,type, userlist);
	 }
}
