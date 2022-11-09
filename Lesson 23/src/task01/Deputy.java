package task01;

import java.util.Scanner;
import java.util.function.Supplier;

public class Deputy extends Human {

	private String name;
	private String surname;
	private int age;
	private boolean briber;
	private int bribeSize;

	public Deputy(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Deputy(String name, String surname, int age, int weight, int height, boolean briber) {
		super(weight, height);
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.briber = briber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBriber() {
		return briber;
	}

	public void setBriber(boolean briber) {
		this.briber = briber;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	public void giveBribe() {
		if (this.briber == false) {
			System.out.println("This deputy does not take bribes.");
		}

		if (this.briber == true) {
			System.out.println("Enter the amount of the bribe:");
			int bribeSize = getBribeSize.get();

			if (bribeSize > 5000) {
				System.out.println("Police will imprison a deputy.");
			} else {
				this.bribeSize = bribeSize;
			}
		}
	}

	Supplier<Integer> getBribeSize = () -> {
		Scanner scanner = new Scanner(System.in);
		int bribeSize = scanner.nextInt();

		return bribeSize;
	};

	@Override
	public String toString() {
		return "Deputy name=" + name + ", surname=" + surname + ", age=" + age + ", briber=" + briber + ", bribeSize="
				+ bribeSize + "";
	}
}