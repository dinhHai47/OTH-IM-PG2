package uebung_11_3;

import java.math.*;
public class Main {
	//BigInteger is Class that can store numbers with an unlimited size. OK, the RAM is the limit.
	private static BigInteger rest = new BigInteger("4");
	private static BigInteger number = new BigInteger("2");
	
	private static BigInteger sub_1 = new BigInteger("2");
	private static BigInteger sub_2 = new BigInteger("1");
	private static BigInteger zero = new BigInteger("0");
	

	public static void main(String[] args) {
		int base = 2;
		int exponent = 86243;
		
		System.out.println("Ist die Zahl " + base + " hoch " + exponent + "-1 " + "eine Primzahl?");
		
		//if the exponent is even, we don´t need to try
		if ((exponent % 2) == 0) {
			System.out.println("2 hoch " + exponent + "-1 ist nicht Prim");
		} else {
			number = number.pow(exponent);
			number = number.subtract(sub_2);
			if(isPrime(exponent)) {
				System.out.println("2 hoch " + exponent + "-1 ist Prim");
			}
			else {
				System.out.println("2 hoch " + exponent + "-1 ist nicht Prim");
			}
		}
	}

	//The Lucas-Lehmer-Algorithm
	public static boolean isPrime(int  exponent){
		for(int i = 0; i < exponent; i++){
			rest = rest.mod(number);
			if(rest.compareTo(zero) == 0){
				break;
			}
			rest = rest.multiply(rest);
			rest = rest.subtract(sub_1);
			//Printing the progress in percent
			if(i % 100 == 0) {
				//System.out.println((double)(i / exponent) * 100);
				System.out.printf("%.2f\n", (i / (double)exponent) * 100);
			}
		}

		if(rest.compareTo(zero) == 0){
			return true;
		}
		else{
			return false;
		}


	}
}
