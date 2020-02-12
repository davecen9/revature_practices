package project_0.menus;
import project_0.utils.InputCheckUtil;
import project_0.utils.ConnectionUtil;
import project_0.DAO.AccountDAO;
import project_0.DAO.UserDao;
import project_0.baseModels.User;

public class UserLoginMenu {
	public static User user;
	public static String username;
	public static void main(String[] args) {
		

	}
	
	public static void loginSession() {

			while(true) {
				System.out.println("Please enter your user id...");
				username = InputCheckUtil.getString(10);
				if(UserDao.getUser(username) == null) {
					System.out.println("User doesn't exist! Please try again.");
				
				}
				else {
					user = UserDao.getUser(username);
					break;
				}
			}
			
			while(true) {
				System.out.println("Please enter your password...");
				String password = InputCheckUtil.getString();
				if(password.equals(user.getPassword())){
					System.out.println("Successfully logged in! Welcome "+user.getFirstname()+"!");
					System.out.println();
					afterloginmenu(user);
					break;
				}
				else {
					System.out.println("Wrong password, please try again!");
				}
				
				}
	}
	
	
	
	
	public static void afterloginmenu(User u) {
		System.out.println("Please choose what you want to do: ");
		System.out.println();
		System.out.println("1. view your accounts");
		System.out.println("2. create bank accounts");
		System.out.println("0. log out");
		Integer selection = InputCheckUtil.getInteger(0,3);
		switch (selection) {
		case 1 : AccountDAO.listAccounts(user);break;
		case 2 : createBankAccount(user);break;
		case 0 : System.out.println("You have successfully logged out!"); MainMenu.mainMenu();
		}
		
	}
	
	
	
	
	public static void createBankAccount(User user) {
		System.out.println("Please decide what type of account do you want: ");
		System.out.println();
		System.out.println("1. Checking");
		System.out.println("2. Credit");
		System.out.println("3. Saving");
		System.out.println("0. go back");
		Integer selection = InputCheckUtil.getInteger(1,3);
		switch (selection) {
		case 1 : BankAccountMainMenu.checkingAccCreation(user); break;
		case 2 : BankAccountMainMenu.creditAccCreation(user); break;
		case 3 : BankAccountMainMenu.savingAccCreation(user); break;
		case 4 : afterloginmenu(user);
		}
		
	}
	
}
