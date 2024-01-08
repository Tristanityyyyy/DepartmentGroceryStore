package package1;
import java.util.*;

public class Products {
	
	static Scanner scn = new Scanner(System.in);
	static Store s = new Store();
	static boolean status = false;
	
	public static void main(String[] args)throws Exception {
		
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
			
            displayMenu();
	        while (!status) {
	            int choice = scn.nextInt();
	            
	            switch (choice) {
	                
	                case 1:
	                	System.out.println("\t \t \t \t" + "PLEASE TYPE [X] WHEN YOU ARE DONE.");
	                	s.buyProd();
	                	break;
	
	                case 2:
	                    status = true;
	                    break;
	                    
	                default:
	                    System.out.println("Invalid choice");
	            }
	            break;
	        }
	    }
		
	}

	public static void menu() {
			
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t******************************************************************************************************************");
			System.out.println("\t \t \t \t \t \t \t \t" + "       Supereme Grocery Store");
			System.out.println("\t \t \t \t \t \t \t \t" + "      Balagtas Bulacan Bulacan");
			System.out.println("\t \t \t \t \t \t \t \t" + "      Contact No : 09564551233");
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t******************************************************************************************************************");
			System.out.println("\t \t \t \t" + "Please log-in your account or sign up.");
			System.out.print("\t \t \t \t" + "Press 'L' to log-in. ");
	}
	static Products p = new Products();
	public static void login() {
		
		
			System.out.print("\t \t \t \t" + "Enter a username: ");
			String usern = scn.next();
			System.out.print("\t \t \t \t" + "Enter a password: ");
			String pass = scn.next();
		
			if(usern.equals("admin") && pass.equals("admin123")) {
				System.out.println("\t \t \t \t" + "Account successfully logged in.");
				System.out.println("\t \t \t==================================================================================================================");
			}
			else {
				System.out.println("\t \t \t \t" + "Account doesn't exist. ");
			}
	}
	
	  public static void displayMenu() {
	        System.out.println("\t \t \t \t" + "==================================");
	        System.out.println("\t \t \t \t" + "| 1. Buy product                 |");
	        System.out.println("\t \t \t \t" + "| 2. Exit                        |");
	        System.out.println("\t \t \t \t" + "==================================");
	        System.out.print("\t \t \t \t" + "Enter your choice: ");
	   }
	  
	
	
}

	
