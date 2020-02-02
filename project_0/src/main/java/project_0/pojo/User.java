package project_0.pojo;

public abstract class User {
	
	protected String userid;

	protected String firstname;
	protected String lastname;
	protected String SSN;
	
	
	
	//general user constructor
	
	public User(String firstname, String lastname, String SSN) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.SSN = SSN;
	}
	
	
	
	//getter and setter methods
	
	public String getId() {
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
