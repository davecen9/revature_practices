package project_0.menus;
import project_0.utils.InputCheckUtil;
import project_0.utils.ConnectionUtil;
import project_0.DAO.UserDao;
import project_0.baseModels.User;

public class UserLoginMenu {
	public static User user;
  
	public static void main(String[] args) {
	while(true) {
		System.out.println("Please enter your user id...");
		String username = InputCheckUtil.getString(10);
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
			break;
		}
		else {
			System.out.println("Wrong password, please try again!");
			}
		
		}
	}
}
