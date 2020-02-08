package project_0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_0.abstract_models.User;
import project_0.utils.ConnectionUtil;



public class UserDao {
	
	
	private User extractUser(ResultSet result) throws SQLException{
		String userid = result.getString("userid");
		String firstname = result.getString("firstname");
		String lastname = result.getString("lastname");
		String SSN = result.getString("SSN");
		
		return new User(userid, firstname, lastname, SSN);
	}
	
	

	public User createUser(User user) {
		try(Connection connection = ConnectionUtil.getConnection()){

			String sql = "INSERT INTO users (userid, firstname, lastname, SSN) VALUES (?,?,?,?) RETURNING*"; 
			PreparedStatement statement = connection.prepareStatement(sql);
					
			statement.setString(1, user.getUserID());
			statement.setString(2, user.getFirstname());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getSSN());
					
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
	
}
