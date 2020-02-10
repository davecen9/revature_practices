package project_0.menus;
import java.io.*;
import project_0.baseModels.*;
import project_0.utils.InputCheckUtil;

public class BankAccountMainMenu {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static int selection;
	public static void main(String[] args, User u) {
			
			System.out.println("What type of account do you need ?");
			System.out.println();
			System.out.println("#Press 1 for a Checking account");
			System.out.println();
			System.out.println("#Press 2 for a Credit account");
			System.out.println();
			System.out.println("#Press 3 for a Saving account");
			System.out.println();
			System.out.println("#Press 0 to go back");
			
			selection = InputCheckUtil.getInteger(0,3);
			switch (selection) {
			case 0: System.out.println("nothing");
			case 1: checkingAccCreation(u);
			case 2: System.out.println("nothing");
			case 3: System.out.println("nothing");
			}
		}
		
	
	
	
	public static void checkingAccCreation(User u) {
		System.out.println("Checking account allows you to perform daily transactions such as deposit"+
	     ", withdraw and transfer money, please follow the instructions below to create your checking"+
				" account. Press 0 anytime to go back");
		Account.accounttype accounttype = Account.accounttype.CHECKING;
		String user = u.getUserID();
		
		System.out.println();
		try {
			while(true) {
				System.out.println("Do you want a 1.SINGLE or 2.JOINT account? Please enter 1 or 2...");
				
				int selection = InputCheckUtil.getInteger(0,2);
				if(selection ==1) {
					Account.accountownershiptype accountownershipttype = Account.accountownershiptype.SINGLE;
				}
				else if (selection ==2) {
					Account.accountownershiptype accountownershipttype = Account.accountownershiptype.JOINT;
				}
				else if (selection ==0) {
					main(null, u);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

