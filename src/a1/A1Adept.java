package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in number of items
		int itemCount = scan.nextInt();
		
		// HashMap to store item names and prices
		HashMap<String, Double> items = new HashMap<String, Double>();
		
		// HashMap to store customer names and total spending
		HashMap<String, Double> customers = new HashMap<String, Double>();
		
		// Scan all items and add to arrays
		for (int i = 0; i < itemCount; i++) {
			String item = scan.next();
			double itemPrice = scan.nextDouble();
			items.put(item, itemPrice);
		}
		
		// Read in number of customers
		int customerCount = scan.nextInt();
		
		// Add data for each customer
		for (int i = 0; i < customerCount; i++) {
			// Read first and last name
			String customerName = scan.next() + " " + scan.next();
			
			// Read in number of items bought
			int itemsBought = scan.nextInt();
			
			// Update total spending for each item bought
			for (int j = 0; j < itemsBought; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				
				// get price from items HashMap
				double price = items.get(item);
				
				// Update customers HashMap to increase total spending
				if (customers.containsKey(customerName)) {
					customers.put(customerName, 
							customers.get(customerName) + price * quantity);
				} else {
					customers.put(customerName, price * quantity);
				}
			}
		}
		
		// Initialize biggest/smallest amount and names
		double biggestAmount = Double.MIN_VALUE;
		String biggestName = "";
		double smallestAmount = Double.MAX_VALUE;
		String smallestName = "";
		
		// Find biggest/smallest amount and names
		for (String name : customers.keySet()) {
			double totalSpending = customers.get(name);
			if (totalSpending > biggestAmount) {
				biggestAmount = totalSpending;
				biggestName = name;
			}
			if (totalSpending < smallestAmount) {
				smallestAmount = totalSpending;
				smallestName = name;
			}
		}
		
		// Calculate average
		double sum = 0;
		for (double amount : customers.values()) {
			sum += amount;
		}
		double average = sum / customers.size();
		
		// Format and print output
		System.out.println("Biggest: " + biggestName 
				+ " (" + String.format("%.2f", biggestAmount) + ")");
		System.out.println("Smallest: " + smallestName
				+ " (" + String.format("%.2f", smallestAmount) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
}
