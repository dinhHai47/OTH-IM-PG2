package uebung_14_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaesarCipher caesarCipher = new CaesarCipher();
		BufferedReader br;
		BufferedWriter bw;
		String input = "";
		String output = "";
		String temp = "";
		try {
			br = new BufferedReader(new FileReader("src/uebung_14_1/Input.txt"));
			while((temp = br.readLine()) != null) {
				input += temp;
			}
			br.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output = caesarCipher.encrypt(input, 4);
		
		try {
			bw = new BufferedWriter(new FileWriter("src/uebung_14_1/Output.txt"));
			bw.write(output);
			bw.flush();
			bw.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
