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
	
	public static void buyProd() throws Exception{
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
	
			System.out.println("\t \t \t==================================================================================================================");
			System.out.println("\t \t \t \t|Product| \t \t \t \t \t|Quantity|         |Price|");
			System.out.println("\t \t \t==================================================================================================================");
			
			while(!resultName.isEmpty()) {
				
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
			c.computationProcess();
			displayPayment();
		}
			catch(InputMismatchException e) {
				System.out.println("\t \t \t \tPlease try again");
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
	    System.out.println("\t \t \t \t" + "| 2. Cancel product              |");
	    System.out.println("\t \t \t \t" + "| 3. Exit                        |");
	    System.out.println("\t \t \t \t" + "==================================");
	    System.out.print("\t \t \t \t" + "Enter your choice: ");
	    int choice = scn.nextInt();
	    switch(choice) {
	    
	    case 1:
		  	System.out.print("\t \t \t \t \t \t \t \t \t \t \t AMOUNT  : ");
			cash = scn.nextDouble();
			double change = cash - c.pricewCharge;
			Math.round(change);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CASH    : " + cash);
		  	System.out.println("\t \t \t \t \t \t \t \t \t \t \t CHANGE  : " + change);
			break;
	    case 2:
	    	cancelProduct();
	    	//cancelProduct();
			//PAANO PAG KULANG ANG BAYAD NG CUSTOMER MAGIGISA KA NG PROF
	    case 3:
	    	break;
	    }
	    
	}
	

	static Queue <Double> quant = new LinkedList();
	static Queue <String> cancProd2 = new LinkedList();
	static Queue <Double> quant2 = new LinkedList(); 
	static Queue <String> cancProd3 = new LinkedList();

	public static void cancelProduct() {
		System.out.println("\t \t \t \t" + "PLEASE ENTER [X] WHEN YOU ARE DONE");
		boolean a = true;
		while(a) {
			System.out.print("\t \t \t \t" + "Enter product id: \t \t");
			String prodId2 = scn.next();
			int incre4 = 0;
			for(Map.Entry <String , String> e : prodHash.entrySet()) {
				if(prodHash.containsKey(prodId2)) {
					quant.offer(price.get(incre4)); //removing of price na di kailangan
					incre4++;
				}
				else {
					incre4++;
				}
			}
			if(prodHash.containsKey(prodId2)) {
				cancProd.remove(prodHash.get(prodId2));
			}
			else if(prodId2.equalsIgnoreCase("X")) {
				break;
			}
		}
		System.out.println("\t \t \t==================================================================================================================");
		System.out.println("\t \t \t \t|Product| \t \t \t \t \t|Quantity|         |Price|");
		System.out.println("\t \t \t==================================================================================================================");
		//resultname dyan yung
		
		// lahat nasave na sa keme pwera sa gusto maremove
		while(!cancProd.isEmpty()) {
			System.out.print("\t \t \t \t" + cancProd.peek());
			System.out.print("\t \t \t \t" + quant.peek());
			
			cancProd2.offer(cancProd.poll());
			quant2.offer(quant.poll()); //SAVEDDDD NAAA QT
			int incre3 = 0;
			
			for(Map.Entry <String , String> e : prodHash.entrySet()) {
				if(e.getValue().equals(cancProd2.peek())) {
					System.out.println("\t \t   "+ price.get(incre3));
					orderedPrice.offer(price.get(incre3)); ////SAVEDDDD NAAAA PRICESSS
					incre3++;
					cancProd3.offer(cancProd2.poll());
				}
				else {
					incre3++;
				}
			}
		}
		c.computationProcessCancel();
		displayPayment();
	}
}

