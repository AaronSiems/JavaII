//Aaron Siems CIS175 Week 5
package view;

import java.util.List;
import java.util.Scanner;


import controller.CoinHelper;
import model.Coin;

public class StartProgram {
			
	static Scanner in = new Scanner(System.in);
	static CoinHelper ch = new CoinHelper();
	
	public static void main(String[] args) {
		mainMenu();
	}

	private static void mainMenu() {
		boolean stay = true;
		System.out.println("What would you like to do today?");
		while(stay) {
			System.out.println("==============================================");
			System.out.println("1 - Add a coin");
			System.out.println("2 - Edit a coin");
			System.out.println("3 - Remove a coin");
			System.out.println("4 - View all coins");
			System.out.println("5 - Exit");
			System.out.println("==============================================");
			System.out.print("Enter a number: ");
			int choice = in.nextInt();
			in.nextLine();
			
			if(choice == 1) {
				addCoin();
			} else if(choice == 2) {
				editCoin();
			} else if(choice == 3) {
				removeCoin();
			} else if(choice == 4) {
				viewCoins();
			} else {
				ch.cleanUp();
				stay = false;
				System.out.println("Shutting down program");
			}
		}
	}

	private static void addCoin() {
		System.out.print("What coin are you adding? ");
		String coinType = in.nextLine();
		System.out.print("What year was this minted? ");
		int year = in.nextInt();
		in.nextLine();
		System.out.print("And what mint mark does it have? ");
		String mint = in.nextLine();
		Coin toAdd = new Coin(coinType, year, mint);
		ch.addCoin(toAdd);
		
	}
	
	private static void editCoin() {
		System.out.println("==============================================");
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by coin type");
		System.out.println("2 : Search by mint year");
		System.out.println("3 : Search by mint mark");
		System.out.println("==============================================");
		System.out.print("Choice: ");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Coin> foundCoins;
		
		if (searchBy == 1) {
			System.out.print("Enter the coin type: ");
			String coinType = in.nextLine();
			foundCoins = ch.searchForCoinByType(coinType);
		} else if(searchBy == 2) {
			System.out.print("Enter the mint year: ");
			int year = in.nextInt();
			in.nextLine();
			foundCoins = ch.searchForCoinByYear(year);
		} else {
			System.out.print("Enter the mint mark: ");
			String mintMark = in.nextLine();
			foundCoins = ch.searchForCoinByMint(mintMark);
		}
		
		
		
		if (!foundCoins.isEmpty()) {
			System.out.println("Found Results.");
			for (Coin l : foundCoins) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("What ID would you like to edit: ");
			int idToEdit = in.nextInt();

			Coin toEdit = ch.searchForCoinById(idToEdit);
			System.out.println("==============================================");
			System.out.println("Updating a " + toEdit.getCoin() + " from " + toEdit.getYear() + ", minted at " + toEdit.getMint());
			System.out.println("1 : Update Coin Type");
			System.out.println("2 : Update Mint Year");
			System.out.println("3 : Update Mint Mark");
			System.out.println("==============================================");
			System.out.print("Choice: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New type: ");
				String newCoinType = in.nextLine();
				toEdit.setCoin(newCoinType);
			} else if (update == 2) {
				System.out.print("New year: ");
				int newYear = in.nextInt();
				in.nextLine();
				toEdit.setYear(newYear);
			} else if (update == 3) {
				System.out.print("New mark: ");
				String newMint = in.nextLine();
				toEdit.setMint(newMint);
			}

			ch.updateCoin(toEdit);

		} else {
			System.out.println("---- No results found");
		}
		
	}

	private static void removeCoin() {
		System.out.println("==============================================");
		System.out.print("Enter the coin type to delete: ");
		String coinType = in.nextLine();
		System.out.print("Enter the mint year to delete: ");
		int year = in.nextInt();
		in.nextLine();
		System.out.print("Enter the mint mark to delete: ");
		String mint = in.nextLine();
		System.out.println("==============================================");
		Coin toDelete = new Coin(coinType, year, mint);
		ch.deleteCoin(toDelete);
	}
	
	
	
	private static void viewCoins() {
		List<Coin> allItems = ch.showAllItems();
		for(Coin singleItem : allItems) {
			System.out.println(singleItem.returnDesc());
		}
	}

}
