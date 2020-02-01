package project_0.pojo;

public class Users {
	private Integer userid;

	private String firstname;
	private String lastname;
	private String SSN;
	
	
	
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
		SSN = SSN;
	}

	public Users(String firstname, String lastname, String SSN) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.SSN = SSN;
	}
}
