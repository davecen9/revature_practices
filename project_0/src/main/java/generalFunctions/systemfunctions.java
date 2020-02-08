package generalFunctions;
import project_0.utils.*;
import project_0.DAO.*;
import project_0.baseModels.*;


public class systemfunctions {
	
	public static void main(String[] args) {
		createUserAccount();
	}
	
	public static void createUserAccount() {
		System.out.println("Please enter user id");
		String userid = InputCheckUtil.getString();
		
		System.out.println();
		System.out.println("Next Step... ");
		System.out.println();
		
		System.out.println("Please enter your first name");
		String firstname = InputCheckUtil.getString();

		
		System.out.println();
		System.out.println("Next Step... ");
		System.out.println();
		
		System.out.println("Please enter your last name");
		String lastname = InputCheckUtil.getString();
		
		System.out.println();
		System.out.println("Next Step... ");
		System.out.println();
		
		System.out.println("Please enter your SSN");
		String SSN = InputCheckUtil.getfixedlengthString(9);
		System.out.println();
		
		System.out.println("Creating user account...");
		
		User newuser = new User(userid, firstname, lastname,SSN );
		newuser = UserDao.createUser(newuser);
		
		System.out.println("Your user account "+userid+" has been successfully created!");
		
	}
	
	public static void createCheckingAcount() {
		
	}
}
