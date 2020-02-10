package project_0.menus;
import project_0.utils.InputCheckUtil;
import project_0.utils.ConnectionUtil;
import project_0.DAO.UserDao;
import project_0.baseModels.User;

public class UserLoginMenu {
	public static void main(String[] args) {


	}
	
	public static User loginSession() {
			User user = null;
			String username = null;
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
					return UserDao.getUser(username);
				}
				else {
					System.out.println("Wrong password, please try again!");
				}
				
				}
	}
	
	
	public static void listAccounts() {
		
	}
}
