package package1;

import java.util.*;

public class Products {
	
	static Scanner scn = new Scanner(System.in);
	static Store s = new Store();
	static boolean status = false;
	public static void main(String[] args) {
		
		while(!status) {
			menu();
			char sign = scn.next().toUpperCase().charAt(0);
			System.out.println(" ");
			
			switch(sign) {
				case 'L':
					login();
				break;
				default:
					System.out.println("Invalid input. Try again.");
			}
			
			
	        while (!status) {
	            displayMenu();
	            int choice = scn.nextInt();
	            
	            switch (choice) {
	                
	                case 1:
	                	Store.buyProd();
	                	break;
	                    
	                case 2:
	                    cancelProduct();
	                    break;
	                    
	                
	                case 3:
	                    status = true;
	                    break;
	                    
	                default:
	                    System.out.println("Invalid choice");
	            }
		
	        }
	    }
		
	}

	public static void menu() {
			
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t******************************************************************************************************************");
			System.out.println("\t \t \t \t \t \t \t \t" + "       Supereme Grocery Store");
			System.out.println("\t \t \t \t \t \t \t \t" + "      Balagtas, Bulacan Bulacan");
			System.out.println("\t \t \t \t \t \t \t \t" + "      Contact No : 09564551233");
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t******************************************************************************************************************");
			System.out.println("\t \t \t \t" + "Please log-in your account or sign up.");
			System.out.print("\t \t \t \t" + "Press 'L' to log-in. ");
	}
	
	public static void login() {
		System.out.print("\t \t \t \t" + "Enter your username: ");
		String usern = scn.next();
		System.out.print("\t \t \t \t" + "Enter your password: ");
		String pass = scn.next();

		if(usern.equals("admin") && pass.equals("admin123")) {
			System.out.println("\t \t \t \t" + "Your account has been successfully logged in.");
			System.out.println("\t \t \t==================================================================================================================");
		}
		else {
			System.out.println("\t \t \t \t" + "Account doesn't exist, Please try logging in again or register a new one. ");
			Products p = new Products();
			Products.main(null);
		}
	}
	
	  public static void displayMenu() {
	        System.out.println("\t \t \t \t" + "------------------------------------");
	        System.out.println("\t \t \t \t" + "|   1. Buy product                 |");
	        System.out.println("\t \t \t \t" + "|   2. Cancel product              |");
	        System.out.println("\t \t \t \t" + "|   3. Exit                        |");
	        System.out.println("\t \t \t \t" + "------------------------------------");
	        System.out.print("\t \t \t \t" + "Enter your choice: ");
	   }
	
	  
	  
	  public static void cancelProduct() {
		  System.out.println("Your transaction has been canceled.");
                  System.out.println("Would you like to buy products or exit?");
		  
	  }
	 
}

	
