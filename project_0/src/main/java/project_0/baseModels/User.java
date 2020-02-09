package project_0.baseModels;

public class User {
	
	private String userid;

	private String firstname;
	private String lastname;
	private String SSN;
	private String password;
	
	
	
	//general user constructor
	
	public User(String userid, String firstname, String lastname, String SSN, String password) {
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.SSN = SSN;
		this.password = password;
	}
	
	
	//getter and setter methods
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserID() {
		return userid;
	}
	public void setId(String id) {
		this.userid = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}


}
