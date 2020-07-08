package uebung_13_1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import uebung_13_1.view.Console;

public class University {
	private String name;
	private List<Student> students;
	private List<Course> courses;

	public University() {
		students = new ArrayList<>();
		courses = new ArrayList<>();
		initCourses();
	}

	public void initCourses() {
		Course course = new Course("Wirtschaftsinformatik (Bachelor)");
		course.addClass("Programmieren 1", 6, 3);
		course.addClass("Programmieren 2", 6, 3);
		course.addClass("BWL 1", 6, 3);
		course.addClass("BWL 3", 6, 3);
		courses.add(course);

		course = new Course("Wirtschaftsinformatik (Master)");
		course.addClass("Moderne Datenbankkonzepte", 5, 3);
		course.addClass("Business Consulting", 5, 3);
		courses.add(course);

		course = new Course("Allgemeine Informatik (Bachelor)");
		course.addClass("Programmieren 1", 6, 3);
		course.addClass("Programmieren 2", 6, 3);
		courses.add(course);
	}

	public void printMainMenu() {
		System.out.println("Was moechten Sie tun?");
		System.out.println("1 - Student hinzufuegen");
		System.out.println("2 - Studentendaten bearbeiten");
		System.out.println("3 - Daten eines Studenten ausgeben");
		System.out.println("4 - Alle Studenten ausgeben");
		System.out.println("5 - Beenden");
	}

	public void printAllStudents(Console console) {
		for (int i = 0; i < students.size(); i++) {
			console.printLine((i + 1) + ": " + students.get(i));
		}
	}

	public void printStudent(int id, Console console) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				console.printLine(students.get(i).getDetailInformation());
			}
		}
	}

	public void editStudent(Scanner scanner) {
		int index = 0;
		for (int i = 0; i < students.size(); i++) {
			System.out.println((i + 1) + ": " + students.get(i).getId());
		}
		System.out.println("Welcher Student?");
		while ((index = scanner.nextInt()) < 1 || index > students.size()) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Welcher Student?");
		}
		scanner.nextLine();
		index--;

		System.out.println("Was moechten Sie tun?");
		System.out.println("1 - Nachname aendern");
		System.out.println("2 - Vorname aendern");
		System.out.println("3 - E-Mail aendern");
		System.out.println("4 - Note eintragen");
		System.out.println("5 - zurueck");

		int choice = 0;
		while ((choice = scanner.nextInt()) != 5) {
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Eingabe machen: ");
				students.get(index).setLastName(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 2:
				System.out.println("Eingabe machen: ");
				students.get(index).setFirstName(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 3:
				System.out.println("Eingabe machen: ");
				students.get(index).seteMail(scanner.nextLine());
				System.out.println(students.get(index).toString() + " geaendert");
				break;
			case 4:
				editGrade(scanner, index);
				break;

			default:
				break;
			}
			System.out.println("Was moechten Sie tun?");
			System.out.println("1 - Nachname aendern");
			System.out.println("2 - Vorname aendern");
			System.out.println("3 - E-Mail aendern");
			System.out.println("4 - Note eintragen");
			System.out.println("5 - zurueck");
		}
	}

	public void editGrade(Scanner scanner, int index) {
		Student student = students.get(index);
		for (int i = 0; i < student.getClasses().size(); i++) {
			System.out.println((i + 1) + ": " + student.getClasses().get(i));
		}

		System.out.println("Welcher Kurs?");
		while ((index = scanner.nextInt()) < 1 || index > student.getClasses().size()) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Welcher Kurs?");
		}
		index--;

		double grade = 0.0;
		System.out.println("Note eingeben:");
		while ((grade = scanner.nextDouble()) < 1.0 || grade > 6.0) {
			scanner.nextLine();
			System.out.println("ungueltige Eingabe");
			System.out.println("Note eingeben:");
		}
		student.getClasses().get(index).setGrade(grade);
		System.out.println(student + " Note eingetragen");
	}

	public void addStudent(String firstName, String lastName, int id, String eMail, Console console) {
		Student newStudent = new Student(firstName, lastName, eMail, id, courses.get(new Random().nextInt(3)));
		students.add(newStudent);
		console.printLine("Added Student");
	}
	
	public void removeStudent(int id, Console console) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				console.printLine("Student removed");
			}
		}
	}

	public List<Student> getStudents() {
		return students;
	}

}
