package task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Faction {

	private String name;
	ArrayList<Deputy> list = new ArrayList<Deputy>();

	public Faction(String name, ArrayList<Deputy> deputy) {
		super();
		this.name = name;
		this.list = deputy;
	}

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getDeputy() {
		return list;
	}

	public void setDeputy(ArrayList<Deputy> deputy) {
		this.list = deputy;
	}

	@Override
	public String toString() {
		return "" + name + "";
	}

	Supplier<Deputy> createDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter surname:");
		String surname = scanner.next();
		System.out.println("Enter age:");
		int age = scanner.nextInt();
		System.out.println("Enter weight:");
		int weight = scanner.nextInt();
		System.out.println("Enter height:");
		int height = scanner.nextInt();
		System.out.println("Is deputy bribe-taker (true/false)?");
		boolean bribeTaker = scanner.nextBoolean();

		return new Deputy(name, surname, age, weight, height, bribeTaker);
	};

	Supplier<Deputy> getDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter surname:");
		String surname = scanner.next();
		
		return new Deputy(name,surname);
	};

	public void addDeputy() {
		Deputy deputy = createDeputy.get();

		if (deputy.isBriber()) {
			deputy.giveBribe();
		}
		list.add(deputy);
		System.out.println(deputy.toString() + " successfully added.");
	}

	public void removeDeputy() {
		Deputy DeputyTyped = getDeputy.get();

		Predicate<Deputy> isEqualNameSurname = deputy -> deputy.getName().equalsIgnoreCase(DeputyTyped.getName())
				&& deputy.getSurname().equalsIgnoreCase(DeputyTyped.getSurname());
		Optional<Deputy> deputyFound = list.stream().filter(isEqualNameSurname).findFirst();

		if (deputyFound.isPresent()) {
			list.remove(deputyFound.get());
			System.out.println("Deputy " + deputyFound.get().toString() + " was removed.");
		} else {
			System.out.println("There is no deputy with this name.");
		}
	}

	public void showAllBribeTakersOfFaction() {
		if (!list.isEmpty()) {
			System.out.println("List of all bribe-takers:");
			list.stream().filter(Deputy::isBriber).forEach(System.out::println);
		} else {
			System.out.println("The faction is empty.");
		}
	}

	public void biggestBribeTakerOfFaction() {
		Deputy max;

		if (!list.isEmpty()) {
			max = list.stream().reduce((e1, e2) -> e1.getBribeSize() > e2.getBribeSize() ? e1 : e2).get();
			System.out.println("The biggest bribe-taker in the faction:\n" + max.toString());
		} else {
			System.out.println("The faction is empty.");
		}
	}

	public void showAllDeputiesOfFaction() {
		if (!list.isEmpty()) {
			System.out.println("All deputies of faction:");
			list.stream().forEach(System.out::println);
		} else {
			System.out.println("The faction is empty.");
		}
	}

	public void clearFaction() {
		list.clear();
	}
}