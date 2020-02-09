package project_0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_0.baseModels.User;
import project_0.utils.ConnectionUtil;



public class UserDao {
	
	
	private static User extractUser(ResultSet result) throws SQLException{
		String userid = result.getString("userid");
		String firstname = result.getString("firstname");
		String lastname = result.getString("lastname");
		String SSN = result.getString("SSN");
		String password = result.getString("password");
		
		return new User(userid, firstname, lastname, SSN, password);
	}
	
	

	public static User createUser(User user) {
		try(Connection connection = ConnectionUtil.getConnection()){

			String sql = "INSERT INTO users (userid, firstname, lastname, SSN,password) VALUES (?,?,?,?,?) RETURNING*"; 
			PreparedStatement statement = connection.prepareStatement(sql);
					
			statement.setString(1, user.getUserID());
			statement.setString(2, user.getFirstname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getSSN());
			statement.setString(5, user.getPassword());
					
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return extractUser(result);
					
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
		}
	
	
	public static User getUser(String userid) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM users WHERE userid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userid);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String SSN = result.getString("SSN");
				String password = result.getString("password");
				return new User(userid, firstname, lastname, SSN,password);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
