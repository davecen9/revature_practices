package project_0.accounts;

import java.util.ArrayList;

import project_0.bankservices.*;
import project_0.baseModels.Account;
import project_0.baseModels.User;
import project_0.baseModels.Account.accountownershiptype;
import project_0.baseModels.Account.accounttype;


public class CheckingAccount extends Account implements CanWithdraw, CanTransfer{
	 


	 private int accountid = 0;
	 private accounttype accounttype = Account.accounttype.CHECKING;
	 private Double creditlimit = 0.0;
	 private Double balance = 0.0;
	 
	 
	 
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

	
	 public CheckingAccount(int accountid, accounttype accounttype, accountownershiptype type,Double balance, Double creditlimit, ArrayList<User> userlist) {
		 super(accountid, accounttype, type, balance, creditlimit,userlist);

		 }
	
	
	public CheckingAccount( accounttype accounttype,accountownershiptype type, ArrayList<User> userlist) {
		 super( accounttype,type, userlist);
	 }
	 
	 //the withdraw service
	 public void Withdraw(Double amount) {
		 if(this.balance >= amount) {
			 this.balance -= amount;
			 System.out.println("Your withdrawl of $"+ amount +" is complete. ");
			 System.out.println("Your remaining balance is "+this.balance);
		 }
		 else {
			 System.out.println("Insufficient account balance...");
		 }
		 
	 }
	 
	 //the transfer service
	 public void Transfer(Account accountid, Double amount) {
		 
			 if(this.balance >= amount) {
				 this.balance -= amount;
				 accountid.setBalance(accountid.getBalance()+amount);
			 }
			 else {
				 System.out.println("Insufficient account balance...");
			 }
		 }
	
	 
	 
}
