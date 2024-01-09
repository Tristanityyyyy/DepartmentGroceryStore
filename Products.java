
package products;
import java.util.*;

public class Products {
	
	public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            Store st  = new Store();
            boolean status = false;
		
		menu();
	        while (!status) {
	            int choice = scn.nextInt();
	            
	            switch (choice) {
	                
	                case 1:
	                    st.buyProd();
                            buyAgain();
	                    break;
	               
	                case 2:
	            	    System.out.close();
	                default:
	                    System.out.println("Invalid choice");
	            }
	            break;
	        }
	    }
		
	
                public static void menu() {
                    Scanner scn = new Scanner(System.in);
                    System.out.println("\t \t \t==================================================================================================================");
                    System.out.println("""
                                       \t \t \t \t \t \t \t      _       __     __                        \r
                                       \t \t \t \t \t \t \t     | |     / /__  / /________  ____ ___  ___ \r
                                       \t \t \t \t \t \t \t     | | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\\r
                                       \t \t \t \t \t \t \t     | |/ |/ /  __/ / /__/ /_/ / / / / / /  __/\r
                                       \t \t \t \t \t \t \t     |__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/ \r
                                                                                 """);
                    System.out.println("\t \t \t==================================================================================================================");

                    System.out.println("\t \t \t==================================================================================================================");
                    System.out.println("\t \t \t******************************************************************************************************************");
                    System.out.println("\t \t \t \t \t \t \t \t" + "       Supreme Grocery Store");
                    System.out.println("\t \t \t \t \t \t \t \t" + "      Balagtas Bulacan Bulacan");
                    System.out.println("\t \t \t \t \t \t \t \t" + "      Contact No : 09564551233");
                    System.out.println("\t \t \t==================================================================================================================");
                    System.out.println("\t \t \t******************************************************************************************************************");
                    System.out.println("\t \t \t \t" + "Please log-in your account or sign up.");
                    System.out.println("\t \t \t \t" + "1. Log in as Customer");
                    System.out.println("\t \t \t \t" + "2. Log in as Admin");
                    System.out.print("\t \t \t \t" + "Enter your choice: ");

                    int choice = scn.nextInt();
                    switch (choice) {
                        case 1 -> login("customer");
                        case 2 -> Admin.display();
                        default -> {
                            System.out.println("\t \t \t \t" + "Invalid input. Try again.");
                            
                        } 
                       
                    }
                  
                } 
	public static void login(String customer) {
		  Scanner scn = new Scanner(System.in);
		        System.out.println("");
			System.out.print("\t \t \t \t" + "Enter a username: ");
			String usern = scn.next();
			System.out.print("\t \t \t \t" + "Enter a password: ");
			String pass = scn.next();
		
			if(!usern.equals("customer") && !pass.equals("customer123")) {
                            System.out.println("\t \t \t \t" + "Account doesn't exist. ");
                        }
			else {
                            System.out.println("\t \t \t \t" + "Account successfully logged in.");
                            System.out.println("\t \t \t=================================================================================================================="); 
                            displayMenu();
                        } 
                      
	}
	
	public static void displayMenu() {
	        System.out.println("\t \t \t \t" + "==================================");
	        System.out.println("\t \t \t \t" + "| 1. Buy product                 |");
	        System.out.println("\t \t \t \t" + "| 2. Exit                        |");
	        System.out.println("\t \t \t \t" + "==================================");
	        System.out.print("\t \t \t \t" + "Enter your choice: ");
	   }
            public static void buyAgain(){
                Scanner scn = new Scanner(System.in);
                    char buyAgain;
                    do {
                        System.out.print(" \t \t \t \t " + "Do you want to buy again? (yes for y and no for n): ");
                        buyAgain = scn.nextLine().charAt(0);
            
                    switch (Character.toLowerCase(buyAgain)) {
                        case 'y':
                            displayMenu(); 
                            int choice = scn.nextInt();
                            Store.buyProd();
                            buyAgain();
                            break;
                        case 'n':
                            System.out.println(" \t \t \t \t " + "Thank you for shopping!");
                            break;
                        default:
                            System.out.println(" \t \t \t \t " + "Invalid input. Please enter 'y' or 'n'.");
                            break;
                    }

                    } while (!(Character.toLowerCase(buyAgain) == 'y' || Character.toLowerCase(buyAgain) == 'n'));


            }
    }
	  

