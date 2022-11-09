package task03;

import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("Enter 1 to add commodity." +
				"\nEnter 2 to show all commodities."+
				"\nEnter 3 to remove commodity."+
				"\nEnter 4 to replace commodity." + 
				"\nEnter 5 to sort list of commodity by name."+
				"\nEnter 6 to sort list of commodity by length." + 
				"\nEnter 7 to sort list of commodity by width."+
				"\nEnter 8 to sort list of commodity by weight." + 
				"\nEnter 9 to display a commodity by id."+
				"\nEnter 10 to exit the program.");
	}

	public static void main(String[] args) {

		Store store = new Store();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();

			switch (scanner.next()) {

			case "1": {
				store.addCommodity();
				break;
			}
			
			case "2":{
				store.showAllCommodity();
				break;
			}

			case "3": {
				store.removeCommodity();
				break;
			}

			case "4": {
				store.replaceCommodity();
				break;
			}

			case "5": {
				store.sortCommodityByName();
				break;
			}

			case "6": {
				store.sortCommodityByLength();
				break;
			}

			case "7": {
				store.sortCommodityByWidth();
				break;
			}

			case "8": {
				store.sortCommodityByWeight();
				break;
			}

			case "9": {
				store.getSpecificCommodity();
				break;
			}

			case "10": {
				System.exit(0);
				break;
			}
			}
		}
	}
}