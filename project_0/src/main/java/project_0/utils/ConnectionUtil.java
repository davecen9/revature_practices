package project_0.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public static void querying(){
		try(Connection connection = ConnectionUtil.getConnection()){
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM users ";
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				System.out.println(result.getString("userid"));
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void inserting() {
		String userid = "davecen9";
		String firstname = "Fan";
		String lastname = "Liang";
		String SSN="293495607";
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO users (userid, firstname, lastname, SSN) VALUES (?,?,?,?) RETURNING*"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, userid);
			statement.setString(2, firstname);
			statement.setString(3, lastname);
			statement.setString(4, SSN);
			
			ResultSet result = statement.executeQuery();

			System.out.println(result);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		String schemasetting = "?currentSchema=project_0";
		String url = System.getenv("project_0_url")+schemasetting;
		String user = System.getenv("project_0_user");
		String password= System.getenv("project_0_password");

		
		try {
			
			return DriverManager.getConnection(url,user,password);
					
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
