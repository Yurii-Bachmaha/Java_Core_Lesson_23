package task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupremeCouncil {

	private static SupremeCouncil instance;

	private SupremeCouncil() {

	}

	public static SupremeCouncil getInstance() {
		if (instance == null) {
			instance = new SupremeCouncil();
		}

		return instance;
	}

	List<Faction> list = new ArrayList<Faction>();

	Supplier<Faction> getFaction = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter faction name:");
		String factionName = scanner.next();

		return new Faction(factionName);
	};

	public Optional<Faction> findFaction() {
		Faction FactionEntered = getFaction.get();

		Predicate<Faction> isEqualFactionName = faction -> faction.getName().equalsIgnoreCase(FactionEntered.getName());
		Optional<Faction> factionFound = list.stream().filter(isEqualFactionName).findFirst();

		return factionFound;
	}

	public void addFaction() {
		Faction faction = getFaction.get();

		list.add(faction);
		System.out.println("Faction " + faction.toString() + " now in supreme council.");
	}

	public void removeFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			list.remove(factionFound.get());
			System.out.println("Faction " + factionFound.get().toString() + " was removed.");
		} else {
			System.out.println("There is no faction with this name in supreme council.");
		}
	}

	public void showAllFactions() {
		if (!list.isEmpty()) {
			System.out.println("All factions in supreme council:\n");
			list.forEach(System.out::println);
		} else {
			System.out.println("There are no factions in supreme council.");
		}
	}

	public void showSpecificFactions() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().showAllDeputiesOfFaction();
		} else {
			System.out.println("There is no such faction in supreme council.");
		}
	}

	public void addDeputyToFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().addDeputy();
		} else {
			System.out.println("There is no such faction in supreme council.");
		}
	}

	public void removeDeputyFromFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().removeDeputy();
		} else {
			System.out.println("There is no such faction in supreme council.");
		}
	}

	public void showAllBribersFromFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().showAllBribeTakersOfFaction();
		}
	}

	public void showBiggestBribeTakerOfFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().biggestBribeTakerOfFaction();
		}
	}

	public void showAllDeputiesOfFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().showAllDeputiesOfFaction();
		}
	}

	public void clearSpecificFaction() {
		Optional<Faction> factionFound = findFaction();

		if (factionFound.isPresent()) {
			factionFound.get().clearFaction();
			System.out.println("Faction " + factionFound.get().toString() + " is empty.");
		} else {
			System.out.println("There is no faction with this name.");
		}
	}
}