package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in count of number of customers
		int customerCount = scan.nextInt();
		
		// Read data for each customer
		for (int i = 0; i < customerCount; i++) {
			
			// Read first and last name of customer
			String firstName = scan.next();
			String lastName = scan.next();
			
			// Initialize totalPrice to 0
			double totalPrice = 0;
			
			// Read in count of items
			int itemCount = scan.nextInt();
			
			// Read data for each item, add price to totalPrice
			for (int j = 0; j < itemCount; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				double price = scan.nextDouble();
				totalPrice += price * quantity;
			}
			
			// format total price to two decimal places
			String formattedTotal = String.format("%.2f", totalPrice);
			
			// Print output
			System.out.println(firstName.substring(0,1) + ". " 
					+ lastName + ": "
					+ formattedTotal);
		}
	}
}
