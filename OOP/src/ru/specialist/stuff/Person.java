package ru.specialist.stuff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person> {
	// 1
	public String name; // = "Unknown";
	// private int age;
	private int birthYear;

	public int getAge() {
		return new Date().getYear() + 1900 - birthYear;
	}

	public void setAge(int age) {
		this.birthYear = new Date().getYear() + 1900 - age;
	}

	public static int counter;// = 0; Одна переменная для всех объектов класса
	public static ArrayList<Person> persons = new ArrayList<Person>();

	static {
		counter = 0;
	}

	/*
	 * // 2 { // Блок инициализации, он выполняется после выражений инициализации
	 * age = name.length(); }
	 */
	public static void showCounter() {
		System.out.printf("Total persons: %d\n", Person.counter);
	}

	// 3
	private Person() {
		this("Неизвестный");
	}

	private Person(String name) {
		this(name, 18);
	}

	public Person(String name, int age) {
		this.name = name;
		setAge(age);
		// this.age = age;
		// Person.counter;
		counter++;
		// persons.add(this);
	}

	public static Person create(String name, int age) {
		Person p = new Person(name, age);
		persons.add(p);
		return p;
	}

	public void show() {
		// this (указатель на текущий класс) - По нему понимает какае данные из какого
		// объекта брать
		System.out.printf("%s - %d\n", this.name, getAge());
	}

	public static final Comparator<Person> byName = 
			(p1, p2) -> p1.name.compareTo(p2.name);
	
	public static void showAll() {
		/*
		 * class ComparePersonByName implements Comparator<Person> {
		 * 
		 * @Override public int compare(Person p1, Person p2) { return
		 * p1.name.compareTo(p2.name); } }
		 */
		/*
		 * Comparator<Person> c = new Comparator<Person>() { public int compare(Person
		 * p1, Person p2) { return p1.name.compareTo(p2.name); } };
		 */

		/*
		 * Collections.sort(persons, new Comparator<Person>() { public int
		 * compare(Person p1, Person p2) { return p1.name.compareTo(p2.name); } });
		 */

		Collections.sort(persons, byName);
		//Collections.sort(persons, (p1, p2) -> p1.getAge() - p2.getAge());
		for (Person p : persons)
			p.show();
	}

	@Override
	public int compareTo(Person p) {
		// return this.name.compareTo(p.name);
		return this.getAge() - p.getAge();
	}
}
