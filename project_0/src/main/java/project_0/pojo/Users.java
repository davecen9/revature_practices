package project_0.pojo;

public abstract class Users {
	protected Integer userid;

	protected String firstname;
	protected String lastname;
	protected String SSN;
	
	public Integer getId() {
		return userid;
	}
	public void setId(Integer id) {
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
