package package1;

import java.util.*;

public class Store{
	static Scanner scn = new Scanner(System.in);
	static Queue q2 = new LinkedList();
	static Queue q = new LinkedList();
	static HashMap <String,String> prodHash = new HashMap<>();
	static ArrayList quantity = new ArrayList();
	static ArrayList price = new ArrayList();
	
	static void products() {
		prodHash.put("000001","Dozen of eggs");
		prodHash.put("000002","50 kg Rice");
		prodHash.put("000003","50 kg BrownRice");
		prodHash.put("000004","Cooking Oil");
		prodHash.put("000005","Vinegar / Suka");
		prodHash.put("000006", "Bottled Water");
		prodHash.put("000007","Pack of Coffee");
		prodHash.put("000008", "Milk Shake");
		prodHash.put("000009", "Ice Cream");
		prodHash.put("000010", "Soy Sauce");
		prodHash.put("000011", "1/4 White Sugar");
		prodHash.put("000012", "1/4 Brown Sugar");
	}
	
	public static void buyProd(){
		Collections.addAll(quantity, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);
		Collections.addAll(price, 2500.00, 130.00, 150.00, 180.00, 250.00, 2000.00, 310.00, 100.00, 100.00, 100.00);
		
		products();		
		System.out.println("\t \t \t==================================================================================================================");
		System.out.println("\t \t \t \t" + "Code \t " + "Product \t \t \t \t \t \t" + "Quantity    " + "Price \n");
		
		int incre = 0;
		for(Map.Entry e : prodHash.entrySet()) {
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
		System.out.println("PLEASE TYPE [D] WHEN YOU ARE DONE.");
		while(a) {
			System.out.print("\t \t \t \t" + "Enter product I.D/Code: \t \t");
			String prodId = scn.next();
			System.out.print("\t \t \t \t" + "Enter product quantity: \t");
			String qt = scn.next();
			System.out.println();
			if(prodId.equalsIgnoreCase("D") || qt.equalsIgnoreCase("D")) {
					a = false;
			}
			else if(!prodId.equalsIgnoreCase("D")) {
					q.offer(prodHash.get(prodId));
					q2.offer(qt);
			}
		}
		
		System.out.println("\t \t \t==================================================================================================================");
		System.out.println("\t \t \t \tProduct \t \t \t \t \t Quantity:        Price: ");
		while(!q.isEmpty()) {
		System.out.print("\t \t \t \t" + q.poll());
		System.out.println("\t \t \t \t \t" + q2.poll());
		}
	}
	
	
}
