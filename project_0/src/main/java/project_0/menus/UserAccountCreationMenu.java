package project_0.menus;

import project_0.DAO.UserDao;
import project_0.baseModels.User;
import project_0.utils.InputCheckUtil;

public class UserAccountCreationMenu {
	public static void main(String[] args) {
		String password;
		System.out.println();
		System.out.println("Welcome to the user accout creation menu...");
		System.out.println();
		System.out.println("Please enter your desired user id");
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
		
		while(true) {
		System.out.println("Please create your password");
		password = InputCheckUtil.getString(15);
		System.out.println();
		
		System.out.println("Please enter your password again to confirm");
		
		String password_confirmation = InputCheckUtil.getString(15);
		System.out.println();
		
		if (!password.equals(password_confirmation)) {
			System.out.println("The passwords don't match! Please try again.");
		}
		else {
			break;
		}
		}
		System.out.println("Creating user account...");
		
		User newuser = new User(userid, firstname, lastname, SSN, password );
		newuser = UserDao.createUser(newuser);
		
		System.out.println("Your user account "+userid+" has been successfully created!");
		}
	}

