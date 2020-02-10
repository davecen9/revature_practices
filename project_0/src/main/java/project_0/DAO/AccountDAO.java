package project_0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project_0.baseModels.Account;
import project_0.baseModels.Account.*;
import project_0.baseModels.User;
import project_0.utils.ConnectionUtil;

public class AccountDAO {
	
	private static int getAccountID(ResultSet result) throws SQLException{ 
		return result.getInt("accountid");
	}
	
	
	private static Account extractAccount(ResultSet result1, ArrayList<User> userlist)throws SQLException{
		String accountid = String.valueOf(result1.getInt("accountid"));
		accounttype accounttype = project_0.baseModels.Account.accounttype.valueOf(result1.getString("accounttype"));
		accountownershiptype accountownershiptype = project_0.baseModels.Account.accountownershiptype.valueOf(result1.getString(("accountownershiptype")));
		Double balance = result1.getDouble("balance");
		Double creditlimit = result1.getDouble("creditlimit");
		
		return new Account(accountid, accounttype, accountownershiptype, balance, creditlimit,userlist);
		
	}
	
	
	
	public static Account createAccount (Account account) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql1 = "INSERT INTO accounts(accounttype, accountownershiptype, balance, creditlimit) "
					+ "VALUES(?,?,?,?) RETURNING *;";
			
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, account.getAccounttype().name());
			statement1.setString(2, account.getAccountownershiptype().name());
			statement1.setDouble(3, account.getBalance());
			statement1.setDouble(4, account.getCreditlimit());
			
			ResultSet result1 = statement1.executeQuery();
			
			int newaccountid = getAccountID(result1);
			
			ArrayList userlist = account.getUsers();
			
			String sql2 = "INSERT INTO users_accounts(userid, accountid) "
					+"VALUES(?,?) RETURNING *;";
			
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			for(User u: account.getUsers()) {
				statement2.setString(1,String.valueOf(u));
				statement2.setInt(2,newaccountid);
			}
			
			ResultSet result2 = statement2.executeQuery();
			
			
			if(result1.next() && result2.next()) {
				Account newaccount = extractAccount(result1,userlist);
				System.out.println("Your "+newaccount.getAccountownershiptype()+" "+newaccount.getAccounttype()+
						" "+"account id: "+newaccount.getAccountid()+" has been successfully created!");
				return newaccount;
			}
			
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
