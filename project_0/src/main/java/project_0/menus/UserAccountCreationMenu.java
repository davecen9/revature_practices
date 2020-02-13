package project_0.menus;

import project_0.DAO.AccountDAO;
import project_0.DAO.UserDao;
import project_0.baseModels.User;
import project_0.utils.InputCheckUtil;

public class UserAccountCreationMenu {

		public static void createUserAccunt() {
			String userid;
			String password;
			
			System.out.println();
			System.out.println("Welcome to the user accout creation menu...");
			System.out.println();
			
			
			
			
			while(true) {
				System.out.println("Please enter your desired user id");
				userid = InputCheckUtil.getString();
				if(AccountDAO.verifyUser(userid)) {
					System.out.println("This userid has been taken, please try another one");
					
				}
				else {
					break;
				}
			}
			
			
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
			
			System.out.println("Please enter your 9 digit SSN");
			String SSN = InputCheckUtil.getfixedlengthString(9);
			System.out.println();
			
			while(true) {
			System.out.println("Please create your password, maximum length 15 characters");
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
			System.out.println();
			System.out.println("Please log in from the main menu");
			System.out.println();
			System.out.println("Redirecting to main menu...");
			MainMenu.mainMenu();
			}
		}
	

