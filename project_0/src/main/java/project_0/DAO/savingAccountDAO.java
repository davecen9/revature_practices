package project_0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_0.baseModels.User;
import project_0.utils.ConnectionUtil;
import project_0.utils.InputCheckUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Timestamp;
import java.sql.Date;



public class savingAccountDAO {
	
	public static void main(String[] args) {

}
		
		
		
		
	
	




	public static void savingDeposit(User user, int accountidpara) {
		
		Double amount = 0.0;
		Double balance = 0.0;
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql0 = "SELECT * FROM transactions WHERE endaccount = ? and trxtype = 'deposit';";
			PreparedStatement statement0 = connection.prepareStatement(sql0);
			statement0.setInt(1, accountidpara);
			ResultSet result0 = statement0.executeQuery();
			if(result0.next()) {
				System.out.println("You can only make one deposit in every saving account.");
				System.out.println("You have made a "+result0.getDouble("trxamount")+" deposit on "+result0.getString("created_at"));
				System.out.println();
				AccountDAO.AccountPage(user, accountidpara);
			}
			
			else {
				
				while(true) {
					System.out.println("Please enter your amount, the minimum deposit amount is $50,000");
					amount = InputCheckUtil.getDouble();
					if(amount>=49999.98) {
						break;
					}
					else if(amount <49999.98){
						System.out.println("The minimum deposit amount is $50,000, please try again");
					}
					else {
						System.out.println("error");
					}
				}
				
				
				
				String sql1 = "SELECT balance FROM accounts Where accountid = ?;";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setInt(1,accountidpara);
				ResultSet result1 = statement1.executeQuery();
				if(result1.next()) {
					balance = result1.getDouble("balance");
				}
				balance +=amount;
				
				
				String sql2 = "UPDATE accounts SET balance = ? WHERE accountid = ? returning*;";
				PreparedStatement statement2 = connection.prepareStatement(sql2);
				statement2.setDouble(1, balance);
				statement2.setInt(2, accountidpara);
				ResultSet result2 = statement2.executeQuery();
				if(result2.next()) {
					System.out.println("Successfully deposited amount! Your new account balance is "+result2.getDouble("balance"));
				}
				
				
				
				String sql3 = "insert into transactions(initaccount ,endaccount,trxtype,trxamount ) values(?,?,?,?) RETURNING*;";
				PreparedStatement statement3 = connection.prepareStatement(sql3);
				statement3.setInt(1, accountidpara);
				statement3.setInt(2, accountidpara);
				statement3.setString(3,"deposit");
				statement3.setDouble(4, amount);
				ResultSet result3 = statement3.executeQuery();
				int transaction_id =0;
				if(result3.next()) {
					transaction_id = result3.getInt("trx_id");
				}
				System.out.println("Your transaction id is "+transaction_id +" please keep it for future reference");
				
				AccountDAO.AccountPage(user, accountidpara);
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void savingWithdraw(User user, int accountidpara) {
		Double amount = 0.0;
		Double balance = 0.0;
		Double creditlimit = 0.0;
		String accounttype = null;
		final Double fee = 0.3;
		String input =null;
		
		updateSavings(user);
	
		try(Connection connection = ConnectionUtil.getConnection()){
			System.out.println("Please type \"confirm\" to confirm your withdrawl, half of your balance will be charged as fees, your account will be closed after the withdrawl");
			System.out.println("Type \"back\" to go back");
			input = InputCheckUtil.getString();
			
			while (true) {
				if(input.equals("confirm")) {
					break;
				}
				else if(input.equals("back")) {
					AccountDAO.AccountPage(user,accountidpara);
				}
				else {
					System.out.println("Please enter valid values");
				}
			}
			
			
			
			String sql1 = "SELECT balance, creditlimit,accounttype FROM accounts Where accountid = ?;";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1,accountidpara);
			ResultSet result1 = statement1.executeQuery();
			if(result1.next()) {
				balance = result1.getDouble("balance");
				creditlimit = result1.getDouble("creditlimit");
				accounttype = result1.getString("accounttype");
			}
			
		
			String sql2 = "UPDATE accounts SET balance = ? WHERE accountid = ? returning*;";
	
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setDouble(1, 0);
			statement2.setInt(2, accountidpara);
			ResultSet result2 = statement2.executeQuery();
			if(result2.next()) {
				System.out.println("Successfully withdrawn "+balance/2+ " ,"+balance/2+" has been charged from your account as fees"  );
				System.out.println("Your account will be closed shortly");
			}
			
			String sql3 = "insert into transactions(initaccount ,endaccount,trxtype,trxamount )"+ 
					"values(?,?,?,?) RETURNING*";
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			statement3.setInt(1, accountidpara);
			statement3.setInt(2, accountidpara);
			statement3.setString(3,"withdraw");
			statement3.setDouble(4, amount);
			statement3.executeQuery();
			
			//closing account
			String sql4 = "DELETE FROM transactions WHERE endaccount =? RETURNING *";
			PreparedStatement statement4 = connection.prepareStatement(sql4);
			statement4.setInt(1, accountidpara);
			statement4.executeQuery();
			
			
			String sql5 = "DELETE FROM users_accounts WHERE accountid = ? RETURNING *";
			PreparedStatement statement5 = connection.prepareStatement(sql5);
			statement5.setInt(1, accountidpara);
			statement5.executeQuery();
			
			String sql6 = "DELETE FROM accounts WHERE accountid = ? RETURNING *";
			PreparedStatement statement6 = connection.prepareStatement(sql6);
			statement6.setInt(1, accountidpara);
			statement6.executeQuery();
			
			System.out.println("Account "+accountidpara +" has been closed. Redirecting to menu.");
			
			AccountDAO.listAccounts(user);
			}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void updateSavings(User user) {

		Double balance = 0.0;
		String accounttype = null;
		Double updatedbalance =0.0;
		
		ArrayList<Integer> accountlist= new ArrayList<Integer>();
		
		Double depositamount = 0.0;
		long diffmilliseconds =0;
		final long halfminsec = 30;
		final long minsec = 60;
		final long daysec = 86400;
		final long thirtydaysinsec = 2592000;
		Double interestrate = 0.5;
		int power =0;
		long division;
		
		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
		Timestamp deposittime = null;
		
		try(Connection connection = ConnectionUtil.getConnection()){
			String getid = "select * from transactions t where trxtype ='deposit' and endaccount in(SELECT accountid FROM accounts " + 
					"WHERE accounttype = 'SAVING');";
			PreparedStatement statementgetid = connection.prepareStatement(getid);
			ResultSet resultgetid = statementgetid.executeQuery();
			while(resultgetid.next()) {
				accountlist.add(resultgetid.getInt("endaccount"));
			}
			
			
			for(int id :accountlist) {
		
				String sql0 = "SELECT * FROM transactions WHERE endaccount = ? and trxtype = 'deposit';";
				PreparedStatement statement0 = connection.prepareStatement(sql0);
				statement0.setInt(1, id);
				ResultSet result0 = statement0.executeQuery();
				if(result0.next()) {
					depositamount = result0.getDouble("trxamount");
					deposittime = result0.getTimestamp("created_at");
					
				}
				diffmilliseconds = (currentTimestamp.getTime() - deposittime.getTime())/1000;
				//System.out.println("diffmilliseconds: "+diffmilliseconds);
				
				
				String sql00 = "SELECT balance FROM accounts WHERE accountid = ?;";
				PreparedStatement statement00 = connection.prepareStatement(sql00);
				statement00.setInt(1,id);
				ResultSet result00 = statement00.executeQuery();
				if(result00.next()) {
					balance = result00.getDouble("balance");
				}
				
				division = diffmilliseconds/halfminsec;
				power = (int) Math.floor(division);
				
				//System.out.println("power: "+power);
				
				updatedbalance = depositamount + (0.005 * power) + 50000;
				
				//System.out.println("updatedbalance: "+updatedbalance);
				String sql000 = "UPDATE accounts SET balance = ? WHERE accountid = ? returning*;";
				
				PreparedStatement statement000 = connection.prepareStatement(sql000);
				statement000.setDouble(1, updatedbalance);
				statement000.setInt(2, id);
				ResultSet result000 = statement000.executeQuery();
			}
			
		
		
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
}
}
