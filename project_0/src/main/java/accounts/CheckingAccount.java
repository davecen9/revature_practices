package accounts;

import project_0.pojo.Account;
import project_0.pojo.User;

public class CheckingAccount extends Account{
	 accounttype accounttype = Account.accounttype.CHECKING;
	 Double creditlimit = 0.0;
	 Double balance = 0.0;
	 
	 
	 public CheckingAccount(accountownershiptype type, String accountid, String loginid, String loginpassword, User ...users) {
		 this.accountownershiptype = type;
		 this.accountid = accountid; //needs to be auto generated
		 this.loginid = loginid;
		 this.loginpassword = loginpassword;
		 for(User u:users) {
			 this.users.add(u);
		 }
	 };
}
