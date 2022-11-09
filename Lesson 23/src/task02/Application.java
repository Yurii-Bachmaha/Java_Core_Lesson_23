package task02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Application {

	public static void main(String[] args) {

		Set<Person> setPerson = new HashSet<Person>();
		Consumer<Person> addToHashSet = personItem -> setPerson.add(personItem);
		addToHashSet.accept(new Person("John", 20));
		addToHashSet.accept(new Person("Lisa", 25));
		addToHashSet.accept(new Person("Abriella", 30));
		addToHashSet.accept(new Person("Barlow", 35));
		addToHashSet.accept(new Person("Emma", 40));
		addToHashSet.accept(new Person("Mia", 45));
		addToHashSet.accept(new Person("Chloe", 50));
		addToHashSet.accept(new Person("Zoe", 55));

		System.out.println("HashSet unsorted list:");
		setPerson.forEach(System.out::println);

		Set<Person> setPerson2 = new TreeSet<Person>();
		Consumer<Person> addToTreeSet = personItem -> setPerson2.add(personItem);
		addToTreeSet.accept(new Person("John", 20));
		addToTreeSet.accept(new Person("Lisa", 25));
		addToTreeSet.accept(new Person("Abriella", 30));
		addToTreeSet.accept(new Person("Barlow", 35));
		addToTreeSet.accept(new Person("Emma", 40));
		addToTreeSet.accept(new Person("Mia", 45));
		addToTreeSet.accept(new Person("Chloe", 50));
		addToTreeSet.accept(new Person("Zoe", 55));

		System.out.println();
		System.out.println("TreeSet list sorted by name:");
		setPerson2.forEach(System.out::println);

		System.out.println();
		System.out.println("TreeSet list sorted by age:");
		setPerson2.stream().sorted(new PersonAgeComparator()).forEach(System.out::println);
	}
}