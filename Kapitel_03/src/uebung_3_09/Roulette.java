package uebung_3_09;

import java.util.Scanner;

public class Roulette {
	public static void main(String[] args) {
		// init game
		Scanner sc = new Scanner(System.in);
		System.out.println("Willkommen beim Roulette");
		int playerMoney = 1000;

		// playing until player runs out of money
		while (playerMoney > 0) {
			System.out.println("Ihr aktuelles Guthaben betraegt " + playerMoney + " Euro.");
			System.out.print("Bitte setzen Sie einen Betrag fuer Ihr naechstes Spiel: ");
			int bet = sc.nextInt();
			sc.nextLine();

			// player can not spend more many than he owns
			if (bet > playerMoney) {
				System.err.println("Der eingesetzte Betrag uebersteigt Ihr Guthaben. Bitte neu setzen.");
				continue;
			}

			System.out.print("Bitte setzen Sie auf eine Farbe (r/s) oder eine Zahl (1-35): ");
			String choice = sc.nextLine();

			// sub bet from players money
			playerMoney -= bet;

			// let the ball run
			int random = getRandomNumber();
			boolean playerWon = false;
			if (choice.equals("r")) {
				// Wenn gerade Zahl, dann rot
				if (random % 2 == 0 && random != 0) {
					System.out.println("   " + random + " - Rot gewinnt, Glueckwunsch");
					playerMoney += bet * 2;
					playerWon = true;
				}
			}
			else if (choice.equals("s")) {
				// Wenn ungerade Zahl, dann schwarz
				if (random % 2 != 0 && random != 0) {
					System.out.println("   " + random + " - Schwarz gewinnt, Glueckwunsch");
					playerMoney += bet * 2;
					playerWon = true;
				}
			}
			else {
				int number = Integer.valueOf(choice);
				if (number >= 0 && number <= 36) {
					if (random == Integer.valueOf(choice)) {
						System.out.println("   " + random + " - Sie gewinnen, Glueckwunsch");
						playerMoney += bet * 35;
						playerWon = true;
					}
				}
			}

			if (!playerWon) {
				System.out.println("   " + random + " - Leider verloren");
			}

			System.out.println("--------------------");
		}
		System.out.println("Vielen Dank fuer Ihren Besuch");
		sc.close();
	}

	public static int getRandomNumber() {
		// creating a random number.
		// found here: http://stackoverflow.com/a/363732
		int min = 0;
		int max = 36;
		int randomInteger = min + (int) (Math.random() * ((max - min) + 1));
		return randomInteger;
	}
}
