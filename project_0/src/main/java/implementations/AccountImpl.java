package implementations;

import java.util.ArrayList;

import project_0.pojo.Accounts;
import project_0.pojo.Users;

public class AccountImpl extends Accounts{

	public AccountImpl(project_0.pojo.Accounts.accountownershiptype accountownershiptype, Integer accountid,
			ArrayList<Users> users, String loginid, Integer loginpassword,
			project_0.pojo.Accounts.accounttype accounttype, Integer balance, Integer creditlimit) {
		super(accountownershiptype, accountid, users, loginid, loginpassword, accounttype, balance, creditlimit);

	}

}
