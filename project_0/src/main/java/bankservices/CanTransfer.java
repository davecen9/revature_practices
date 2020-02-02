package bankservices;

import project_0.pojo.Account;

public interface CanTransfer {
	void Transfer(Account accountid, Integer amount, boolean transferout);

}
