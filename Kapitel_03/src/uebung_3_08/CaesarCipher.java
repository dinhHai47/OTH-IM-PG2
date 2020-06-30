package uebung_3_08;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// message to encrypt:
		String startMessage;
		String encryptedMessage;
		String decryptedMessage;

		System.out.println("Nachricht zum Verschluesseln eingeben");
		startMessage = scanner.nextLine();
		// encryption key
		System.out.println("Schluessel zum Verschluesseln eingeben");
		int encryptionKey = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Unverschluesselte Nachricht : " + startMessage);
		System.out.println("Key zur Verschluesselung    : " + encryptionKey);

		System.out.println("---------------");

		// encrypt and print to console
		encryptedMessage = encryptAlternative1(startMessage, encryptionKey);
		System.out.println("Verschluesselte Nachricht #1: " + encryptedMessage);

		encryptedMessage = encryptAlternative2(startMessage, encryptionKey);
		System.out.println("Verschluesselte Nachricht #2: " + encryptedMessage);

		System.out.println("---------------");

		System.out.println("Nachricht zum Entschluesseln eingeben");
		encryptedMessage = scanner.nextLine();
		System.out.println("Schluessel zum Entschluesseln eingeben");
		encryptionKey = scanner.nextInt();
		scanner.nextLine();

		// Decrypt the message with the key the user entered
		decryptedMessage = decryptAlternative1(encryptedMessage, encryptionKey);
		System.out.println("Entschluesselte Nachricht #1: " + decryptedMessage);

		decryptedMessage = decryptAlternative2(encryptedMessage, encryptionKey);
		System.out.println("Entschluesselte Nachricht #2: " + decryptedMessage);

		scanner.close();
	}

	public static String encryptAlternative1(String text, int key) {
		String output = "";

		// Algorithmus: (P + K) mod 26, wobei P hier der zu verschlüsselnde Buchstabe
		// und K der Key ist
		for (char c : text.toCharArray()) {
			int encryptedC = (((c - 'a') + key) % 26) + 'a';
			output += (char) encryptedC;
		}

		return output;
	}

	public static String encryptAlternative2(String text, int key) {
		String output = "";

		for (char c : text.toCharArray()) {
			// Umwandlung des derzeitigen Buchstabens der "startMessage" zu int
			int cInt = (int) c;
			for (int i = 1; i <= key; i++) {
				// Zyklische Verschiebung nach rechts
				cInt++;
				if (cInt == ('z' + 1)) {
					cInt = 'z' + 1 - 26;
				}
			}
			output += (char) (cInt);
		}

		return output;
	}

	public static String decryptAlternative1(String text, int key) {
		String output = "";

		for (char c : text.toCharArray()) {
			int encryptedC = (((c - 'a') - key) % 26) + 'a';
			if (encryptedC < 'a') {
				encryptedC += 'z' - 'a' + 1;
			}
			output += (char) encryptedC;
		}

		return output;
	}

	public static String decryptAlternative2(String text, int key) {
		String output = "";

		for (char c : text.toCharArray()) {
			// Umwandlung des derzeitigen Buchstabens der "startMessage" zu int
			int cInt = (int) c;
			for (int i = 1; i <= key; i++) {
				// Zyklische Verschiebung nach links
				cInt--;
				if (cInt == ('a' - 1)) {
					cInt = 'a' - 1 + 26;
				}
			}
			output += (char) (cInt);
		}

		return output;
	}
}
