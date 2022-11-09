package task03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Store {

	ArrayList<Commodity> store = new ArrayList<Commodity>();

	Supplier<Commodity> getCommodity = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of product:");
		String name = scanner.next();
		System.out.println("Enter length of product:");
		double length = scanner.nextDouble();
		System.out.println("Enter width of product:");
		double width = scanner.nextDouble();
		System.out.println("Enter weight of product:");
		double weight = scanner.nextDouble();

		return new Commodity(name, length, width, weight);
	};

	public Optional<Commodity> findCommodity() {
		Commodity commodityTyped = getCommodity.get();

		Predicate<Commodity> isEqualCommodity = commodity -> commodity.getName()
				.equalsIgnoreCase(commodityTyped.getName()) && commodity.getLength() == commodityTyped.getLength()
				&& commodity.getWidth() == commodityTyped.getWidth()
				&& commodity.getWeight() == commodityTyped.getWeight();
		Optional<Commodity> commodityFound = store.stream().filter(isEqualCommodity).findFirst();

		return commodityFound;
	}
	
	public void showAllCommodity() {
		if(!store.isEmpty()) {
			System.out.println("All commodities in the store: ");
			store.forEach(System.out::println);
		}else {
			System.out.println("Store is empty.");
		}
	}

	public void addCommodity() {
		Commodity commodity = getCommodity.get();

		store.add(commodity);
		System.out.println(commodity.toString() + " successfully added to the store.");
	}

	public void removeCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			store.remove(commodityFound.get());
			System.out.println("Commodity " + commodityFound.toString() + " successfully removed.");
		} else {
			System.out.println("There is no commodity with that characteristics.");
		}
	}

	public void replaceCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			System.out.println("Enter the commodity you want to replace:");
			Commodity newCommodityTyped = getCommodity.get();

			commodityFound.get().setName(newCommodityTyped.getName());
			commodityFound.get().setLength(newCommodityTyped.getLength());
			commodityFound.get().setWidth(newCommodityTyped.getWidth());
			commodityFound.get().setWeight(newCommodityTyped.getWeight());

			System.out.println("Entered commodity successfully replaced by " + commodityFound.get().toString());
		} else {
			System.out.println("There is no commodity with that name.");
		}
	}

	public void sortCommodityByName() {
		System.out.println("Before sorting:");
		store.forEach(System.out::println);

		System.out.println("After sorting by name:");
		store.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
	}

	public void sortCommodityByLength() {
		System.out.println("Before sorting:");
		store.forEach(System.out::println);

		System.out.println("After sorting by length:");
		store.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
	}

	public void sortCommodityByWidth() {
		System.out.println("Before sorting:");
		store.forEach(System.out::println);

		System.out.println("After sorting by width:");
		store.stream().sorted(Comparator.comparing(Commodity::getWidth)).forEach(System.out::println);
	}

	public void sortCommodityByWeight() {
		System.out.println("Before sorting:");
		store.forEach(System.out::println);

		System.out.println("After sorting by weight:");
		store.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

	public void getSpecificCommodity() {
		System.out.println("Enter id of commodity:");
		Scanner scanner = new Scanner(System.in);
		int ordinal = scanner.nextInt();

		if (ordinal < 0 || ordinal > (store.size() - 1)) {
			System.out.println("There is no commodity with this id.");
		} else {
			System.out.println(ordinal + " is id of the" + store.get(ordinal).toString());
		}
	}
}