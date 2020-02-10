package project_0.menus;

import project_0.utils.InputCheckUtil;

public class MainMenu {
	public static void main(String[] args) {
		System.out.println("Welcome to the XXX banking system  ");
		System.out.println();
		System.out.println();
		System.out.println("................Main Menu.................");
		System.out.println();
		System.out.println();
		System.out.println( "Already have an account?");
		System.out.println("#Press 1 to log in");
		System.out.println();
		System.out.println("Need an account? ");
		System.out.println("#Press 2 to sign up for an account");
		System.out.println();
		System.out.println("Need help?");
		System.out.println("#Press 3 for customer service");
		
		int selection = InputCheckUtil.getInteger(1, 3);
		switch(selection) {
		case 1: System.out.println("nothing here yet"); break;
		case 2: UserAccountCreationMenu.main(args);; break;
		case 3: System.out.println("All the account representatives are busy at the moment, bye! :D");break;
		}
	}
	

	
	
}
