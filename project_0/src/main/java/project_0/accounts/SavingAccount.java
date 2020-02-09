package project_0.accounts;

import project_0.baseModels.Account;
import project_0.baseModels.User;


public class SavingAccount extends Account{
	accounttype accountype = Account.accounttype.SAVING;
	Double creditlimit = 0.0;
	Double balance = 5000.0;
	
	public SavingAccount( accounttype accounttype,accountownershiptype type, User ...users) {
		super(accounttype,type, users);
	}
}
