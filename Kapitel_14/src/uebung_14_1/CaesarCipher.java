package uebung_14_1;

public class CaesarCipher {

	public String encrypt(String text, int key) {
		String output = "";

		// Algorithm: (P + K) mod 26, P is the letter to encrypt and K the key
		for (char c : text.toCharArray()) {
			int encryptedC = (((c - 'a') + key) % 26) + 'a';
			output += (char) encryptedC;
		}

		return output;
	}

	// Algorithm: (P - K) mod 26, P is the letter to decrypt and K the key
	public String decrypt(String text, int key) {
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
}
