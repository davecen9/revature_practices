package project_0.pojo;

import java.util.ArrayList;

public class Accounts {
	
	public enum accountownershiptype{
		SINGLE,JOINT;
	}
	
	public enum accounttype{
		CHECKING,SAVING,CREDIT;
	}
	
	public ArrayList<Users> getUsers() {
		return users;
		}
		
	
	public void setUsers(Users ...users) {
		for(Users u : users) {
			this.users.add(u);
		}
		
	}
	
	
	private Integer accountid;
	
	private ArrayList<Users> users;
	
	private String loginid;
	
	private Integer loginpassword;
	
	private accounttype accounttype;
	
	private Integer balance;
	
	private Integer creditlimit;
}
