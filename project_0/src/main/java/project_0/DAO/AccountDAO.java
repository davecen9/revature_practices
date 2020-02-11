package project_0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project_0.accounts.CheckingAccount;
import project_0.baseModels.Account;
import project_0.baseModels.Account.*;
import project_0.baseModels.User;
import project_0.menus.UserLoginMenu;
import project_0.utils.ConnectionUtil;
import project_0.utils.InputCheckUtil;

public class AccountDAO {
	
	public static void main(String[] args) {
		User user = new User("davecen9","fanliang","cen","294597053","294597053");
		//listAccounts(user);
//		ArrayList<User> userlist = new ArrayList<User>();
//		userlist.add(user);
//		Account checkingacc = new CheckingAccount(accounttype.CHECKING,accountownershiptype.SINGLE,userlist);
//		createAccount(checkingacc);
	}
	
	
	private static Account extractAccount(ResultSet result, ArrayList<User> userlist)throws SQLException{
		int accountid = result.getInt("accountid");
		accounttype accounttype = project_0.baseModels.Account.accounttype.valueOf(result.getString("accounttype"));
		accountownershiptype type = project_0.baseModels.Account.accountownershiptype.valueOf(result.getString(("accountownershiptype")));
		Double balance = result.getDouble("balance");
		Double creditlimit = result.getDouble("creditlimit");
		Account newaccount = new Account(accountid, accounttype, type, balance, creditlimit, userlist);
		return newaccount;
		
	}
	
	
	
	public static Account createAccount (Account account) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO accounts(accounttype, accountownershiptype, balance, creditlimit) "
					+ "VALUES(?,?,?,?) RETURNING *;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccounttype().name());
			statement.setString(2, account.getAccountownershiptype().name());
			statement.setDouble(3, account.getBalance());
			statement.setDouble(4, account.getCreditlimit());
			
			ArrayList<User> userlist = account.getUsers();
			ResultSet result = statement.executeQuery();

			 
			
			if(result.next()) {
			Account newaccount = extractAccount(result,userlist);
			System.out.println("Your "+newaccount.getAccountownershiptype()+" "+newaccount.getAccounttype()+
					" "+"account id: "+newaccount.getAccountid()+" has been successfully created!");
			createUserAccountRelation(newaccount);
			return newaccount;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	
	public static void createUserAccountRelation(Account account) {
		try(Connection connection = ConnectionUtil.getConnection()) {

			
			int newaccountid = account.getAccountid();
			
			String sql = "INSERT INTO users_accounts(userid, accountid) "
					+"VALUES(?,?) RETURNING *;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			for(User u: account.getUsers()) {
				statement.setString(1,u.getUserID());
				statement.setInt(2,account.getAccountid());
				ResultSet result = statement.executeQuery();
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void listAccounts(User user){
		ArrayList<Account> accountlist = new ArrayList<Account>();
		try(Connection connection = ConnectionUtil.getConnection()){
			
			String sql = "select * from accounts where accountid in("+
					"select accountid from users_accounts where userid = ?);";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUserID());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int accountid = result.getInt("accountid");
				accounttype type1 = accounttype.valueOf(result.getString("accounttype"));
				accountownershiptype type2 = accountownershiptype.valueOf(result.getString("accountownershiptype"));
				Double balance = result.getDouble("balance");
				Double creditlimit = result.getDouble("creditlimit");
				accountlist.add(new Account(accountid,type1,type2, balance,creditlimit));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Your accounts: ");
		System.out.println();
		System.out.printf("%-10s  %-30s  |  %-20s |  %-20s   |%-20s", "Item","Account Ownership Type", "Account Category", "Account ID","Balance");
		System.out.println();
		for(Account a : accountlist) {
			//System.out.printf("%i .%s %s Account id %i",accountlist.indexOf(a)+1, a.getAccountownershiptype().name(),a.getAccounttype().name(),a.getAccountid());
			System.out.printf("%-10d  %-30s  |  %-20s |  %-20d   |%-20.2f", (accountlist.indexOf(a)+1),a.getAccountownershiptype().name(),a.getAccounttype().name(),a.getAccountid(), a.getBalance());
			System.out.println();
		}
		System.out.println("Please select the account you want to view account dashboard...press 0 to go back");
		System.out.println();
		int input = InputCheckUtil.getInteger();
		if(input ==0) {
			UserLoginMenu.afterloginmenu(user);
		}
		else if (input <accountlist.size()) {
			int accountidpara = accountlist.get(input-1).getAccountid();
			AccountPage(user, accountidpara);
		}
		else {
			System.out.println("Please try again");
			listAccounts(user);
		}
	}


	public static void AccountPage(User user,int accountidpara) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM accounts WHERE accountid = ?;";
			PreparedStatement statement =connection.prepareStatement(sql);
			statement.setInt(1, accountidpara);
			ResultSet result = statement.executeQuery();
			Account returnaccount = null;
			if(result.next()) {
				int accountid = result.getInt("accountid");
				accounttype type1 = accounttype.valueOf(result.getString("accounttype"));
				accountownershiptype type2 = accountownershiptype.valueOf(result.getString("accountownershiptype"));
				Double balance = result.getDouble("balance");
				Double creditlimit = result.getDouble("creditlimit");
				returnaccount = new Account(accountid,type1,type2,balance,creditlimit);
			}
			System.out.println();
			System.out.println("Your account: ");
			System.out.println();
			System.out.printf("%-10s  %-30s  |  %-20s |  %-20s   |%-20s", "Item","Account Ownership Type", "Account Category", "Account ID","Balance");
			System.out.println();
			System.out.printf("%-10d  %-30s  |  %-20s |  %-20d   |%-20.2f", 1, returnaccount.getAccountownershiptype().name(),returnaccount.getAccounttype().name(),returnaccount.getAccountid(), returnaccount.getBalance());
			System.out.println();
			System.out.println();
			System.out.println("Please select what you want to do, enter 0 to go back");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Transfer");
			int selection = InputCheckUtil.getInteger(0,3);
			switch (selection) {
			case 0: listAccounts(user);
			case 1: System.out.println("deposit");
			case 2: System.out.println("deposit");
			case 3: System.out.println("deposit");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


