package uebung_13_1.controller;

import java.util.ArrayList;
import java.util.List;

import uebung_13_1.model.University;
import uebung_13_1.view.Console;
import uebung_13_1.view.MainFrame;

//Class for interaction between model and view
public class Controller {
	private MainFrame mainFrame;
	private Console console;
	private University university;

	public Controller() {
		this.mainFrame = new MainFrame(this);
		this.console = new Console();
		this.university = new University();
	}

	public void addStudent(String firstName, String lastName, int id, String eMail) {
		university.addStudent(firstName, lastName, id, eMail, console);
		updateView();
	}

	public void printStudent(int id) {
		university.printStudent(id, console);
	}

	public void printAllStudents() {
		university.printAllStudents(console);
	}
	
	public void removeStudent(int id) {
		university.removeStudent(id, console);
		updateView();
	}
	
	//create an object of every student and pass it to the view for updating the table
	public void updateView() {
		List<Object[]> entries = new ArrayList<>();
		Object[] entry;
		for (int i = 0; i < university.getStudents().size(); i++) {
			entry = new Object[] { university.getStudents().get(i).getFirstName(), university.getStudents().get(i).getLastName(), university.getStudents().get(i).getId(),
					university.getStudents().get(i).geteMail() };
			entries.add(entry);
		}
		mainFrame.updateTable(entries);
	}

}
