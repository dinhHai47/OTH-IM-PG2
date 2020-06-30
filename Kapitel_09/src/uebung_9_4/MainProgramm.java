package uebung_9_4;

import java.util.Scanner;

public class MainProgramm {
	public static void main(String[] args) {

		// create a pub
		VirtualPub vPub = new VirtualPub(10);
		// Erzeugt einen Kunden
		Person customer = new Person();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Geben Sie die Temperatur eines kalten Getränkes ein: ");
			String input = sc.nextLine();
			Drink drink;

			try {
				drink = new Drink(Integer.parseInt(input), 8);
			}
			catch (NumberFormatException e) {
				System.out.println("Es werden nur ganze Zahlen akzeptiert");
				continue;
			}

			try {
				vPub.serveCustomer(customer, drink);
				System.out.println("Das Getränk ist optimal und der Kunde ist zufrieden");
			}
			catch (TooColdException e) {
				System.out.println(e.getMessage());
			}
			catch (TooHotException e) {
				System.out.println(e.getMessage());
			}
			catch (StorageEmpty e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
