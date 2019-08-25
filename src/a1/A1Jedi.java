package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in count of items
		int itemCount = scan.nextInt();
		
		/* Arrays to store item names, how many 
		 * different customers bought each item, and the 
		 * total quantity of each item bought by all customers
		*/
		String[] items = new String[itemCount];
		int[] differentCustomers = new int[itemCount];
		int[] total = new int[itemCount];
		
		// Add each item name to the array
		for (int i = 0; i < itemCount; i++) {
			items[i] = scan.next();
			
			// Skip prices, since they are irrelevant to this problem
			scan.nextDouble();
		}
		
		// Read in count of customers
		int customerCount = scan.nextInt();
		
		for (int i = 0; i < customerCount; i++) {
			// Skip customer names, since they are irrelevant to this problem
			scan.next();
			scan.next();
			
			/* This array will be used to keep track of items a customer 
			 * has already purchased, so that items that show up more
			 * than once wont count twice toward the differentCustomer
			 * count.
			 */
			boolean[] alreadyPurchased = new boolean[itemCount];
			
			// Read in count of items
			int customerItemCount = scan.nextInt();
			
			for (int j = 0; j < customerItemCount; j++) {
				// Store item amount and name
				int amount = scan.nextInt();
				String item = scan.next();
				
				// Find index of item in arrays
				int index = -1;
				for (int k = 0; k < items.length; k++) {
					if (item.equals(items[k])) {
						index = k;
					}
				}
				
				/* Increment differentCustomer count if customer 
				 * has not already purchased this item
				*/
				if (!alreadyPurchased[index]) {
					differentCustomers[index]++;
					alreadyPurchased[index] = true;
				}
			
				// Increase total count for this item
				total[index] += amount;
			}
		}
		
		// Format and print output for each item
		for (int i = 0; i < items.length; i++) {
			if (total[i] == 0) {
				System.out.println("No customers bought " + items[i]);
			} else {
				System.out.println(differentCustomers[i] 
						+ " customers bought " 
						+ total[i] + " " + items[i]);
			}
		}
		
	}
}
