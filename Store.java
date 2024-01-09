package package1;

import java.util.*;

public class Store{
	static Scanner scn = new Scanner(System.in);
	
	static Queue <Double> resultQuant = new LinkedList();
	static Queue <String> resultName = new LinkedList();
	static Queue <Double>resultPrice = new LinkedList();
	
	static LinkedHashMap <String,String> prodHash = new LinkedHashMap<>();
	static ArrayList <Integer> quantity = new ArrayList();
	static ArrayList <Double>price = new ArrayList();

	static Queue <String> orderedProd = new LinkedList();
	static Queue <Double> orderedQuantity = new LinkedList();
	static Queue <Double>orderedPrice = new LinkedList();
	static Computation c = new Computation();
	
	static Queue <String> cancProd = new LinkedList();
	
	static void products() {
		prodHash.put("00001","Dozen of eggs     ");
		prodHash.put("00002","50 kg Rice        ");
		prodHash.put("00003","50 kg BrownRice   ");
		prodHash.put("00004","Cooking Oil       ");
		prodHash.put("00005","Vinegar / Suka    ");
		prodHash.put("00006","Bottled Water     ");
		prodHash.put("00007","Pack of Coffee    ");
		prodHash.put("00008", "Milk Shake       ");
		prodHash.put("00009", "Ice Cream        ");
		prodHash.put("00010", "Pack of Sugar    ");
		prodHash.put("00011", "Soda Drink       ");
		prodHash.put("00012", "Corned Beef      ");
		prodHash.put("00013", "All purpose Cream");
		
	}
	
	static String prodId;
	static double qt;
	
	
	static double cash;
	
	public static void buyProd(){
		try {
			Collections.addAll(quantity, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
			Collections.addAll(price,230.00, 2000.00, 2500.00, 130.00, 250.00, 25.00, 180.00 , 100.00, 300.00, 270.00, 85.00, 70.00, 150.00);
			
			products();		
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t \t" + "Code \t " + "Product \t \t \t \t \t \t \t" + "Quantity    " + "Price \n");
			
			
			
			int incre = 0;
			for(Map.Entry <String , String> e : prodHash.entrySet()) {
				for (int i = 0; i < 1; i++) {
					
					System.out.print("\t \t \t \t" + e.getKey());
					System.out.print("\t" + e.getValue());
					
					System.out.print("\t \t \t \t \t \t" + quantity.get(incre));
					System.out.println("         "  + price.get(incre));
					incre++;
				}
			}
			
			
			System.out.println("\t \t \t==================================================================================================================");
			
			boolean a = true;
			
			while(a) {
				System.out.println("\t \t \t \t" + "PLEASE TYPE [X] WHEN YOU ARE DONE.");
				System.out.print("\t \t \t \t" + "Enter product id: \t \t");
				prodId = scn.next();
				
				if(prodId.equalsIgnoreCase("X") ) {
					if(prodId.isEmpty()) {
						c.computationProcessCancel();
						displayPayment();
					}
					break;
				}
				
				System.out.print("\t \t \t \t" + "Enter product quantity: \t");
				qt = scn.nextDouble();

				System.out.println();
				if(!prodId.equalsIgnoreCase("X") || qt == 0) {
						resultName.offer(prodHash.get(prodId));
						resultQuant.offer(qt);
				}
			}
	System.out.println("");
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t \t|Product| \t \t \t \t \t|Quantity|         |Price|");
			System.out.println("\t \t \t==================================================================================================================");
			
			if(resultName.isEmpty()) {
				Products.main(null);
			}
			else if(!resultName.isEmpty()) {
				while(!resultName.isEmpty()){
					System.out.print("\t \t \t \t" + resultName.peek());
					System.out.print("\t \t \t \t" + resultQuant.peek());
					
					orderedProd.offer(resultName.poll());
					orderedQuantity.offer(resultQuant.poll()); //SAVEDDDD NAAA QT
	
					int incre2 = 0;
		
					for(Map.Entry <String , String> e : prodHash.entrySet()) {
						if(e.getValue().equals(orderedProd.peek())) { // keme.peek
							System.out.println("\t \t   "+ price.get(incre2));
							orderedPrice.offer(price.get(incre2)); ////SAVEDDDD NAAAA PRICESSS
							incre2++;
							cancProd.offer(orderedProd.poll());
						}
						else {
							incre2++;
						}
					}	 
				}
			}
			c.computationProcess();
			displayPayment();
		}
			catch(InputMismatchException e) {
				System.out.println("\t \t \t \tPlease try again");
				Products.main((null));
			}
	}
	
	public static void displayPayment() {
		Scanner scn = new Scanner(System.in);
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------");
		
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTAXABLE TOTAL    : " + c.totalPrice);
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tVat(12%)         : " + c.vatPrice + "\n");
	  	System.out.println("\t \t \t \t \t \t \t \t \t \tTOTAL            : " + c.pricewCharge);

		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("\t \t \t \t" + "==================================");
	    System.out.println("\t \t \t \t" + "| 1. Pay                         |");
	    System.out.println("\t \t \t \t" + "| 2. Cancel the products         |");
	    System.out.println("\t \t \t \t" + "| 3. Exit                        |");
	    System.out.println("\t \t \t \t" + "| 4. Menu                        |");
	    System.out.println("\t \t \t \t" + "==================================");
	    System.out.print("\t \t \t \t" + "Enter your choice: ");
	    int choice = scn.nextInt();
	    while(!cancProd.isEmpty()) {
	    	Admin.soldProd.offer(cancProd.poll());
	    }
		System.out.println("\t \t \t------------------------------------------------------------------------------------------------------------------\n");

	    switch(choice) {
	    
	    case 1:
		  	System.out.print("\t \t \t \t \t \t \t \t \t \t \t AMOUNT  : ");
			cash = scn.nextDouble();
			double change = cash - c.pricewCharge;
			Math.round(change);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CASH    : " + cash);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CHANGE  : " + change);
		  	Admin.cashOn.offer(c.pricewCharge);
		  	
		  	Products.main(null);
		  	break;
	    case 2:
	    	cancelProduct();
	    case 3:
	    	break;
	    case 4:
	    	Products.main(null);
	    case 5:
	    	Admin.display();
	    }
	    	
	    
	}
	

	static Queue <Double> quant = new LinkedList();
	static Queue <String> cancProd2 = new LinkedList();
	static Queue <Double> quant2 = new LinkedList(); 
	static Queue <String> cancProd3 = new LinkedList();
	
	public static void cancelProduct() {
		while(!resultName.isEmpty()) {
			resultName.poll();
			resultQuant.poll();

		}
	}
}
