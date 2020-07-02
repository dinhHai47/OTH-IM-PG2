package uebung_11_2;

import java.util.Random;

public class StartBubbleSort {

	public static void main(String[] args) {
		int count = 100000;
		Random random = new Random();
		int numbers[] = new int[count];

		generateRandomNumbers(numbers, count, random);
//		printArray(numbers);
		System.out.println("Sortieren von " + numbers.length + " Zahlen");

		BubbleSort bubbleSort = new BubbleSort();

		//Time measurement how long it takes to sort the array
		double time = System.currentTimeMillis();
		bubbleSort.bubbleSort(numbers);
		time = System.currentTimeMillis() - time;
		time = time / 1000;

//		printArray(numbers);
		System.out.println("Das Sortieren hat " + time + " Sekunden gedauert");

	}

	//prints the number-array
	public static void printArray(int numbers[]) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println();
	}

	//generates random numbers between 0 and 99
	public static void generateRandomNumbers(int numbers[], int count, Random random) {
		for (int i = 0; i < count; i++) {
			numbers[i] = random.nextInt(100);
		}
	}

}
