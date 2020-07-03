package uebung_11_2;

public class MergeSort {
	int numbers[];

	public MergeSort(int numbers[]) {
		this.numbers = numbers;
	}

	/*
	 * Divide and conquer: The number-array is divided by half as long as it
	 * contains more then one number.
	 */
	private void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	// Merge the two sorted arrays in in sorted array and write that part back to
	// the original array.
	private void merge(int low, int mid, int high) {
		int lowCounter = low;
		int highCounter = mid + 1;
		int sortedCounter = 0;
		int sortedNumbers[] = new int[high - low + 1];

		while (lowCounter <= mid && highCounter <= high) {
			if (numbers[lowCounter] > numbers[highCounter]) {
				sortedNumbers[sortedCounter] = numbers[highCounter];
				highCounter++;
			}
			else {
				sortedNumbers[sortedCounter] = numbers[lowCounter];
				lowCounter++;
			}
			sortedCounter++;
		}

		while (lowCounter <= mid) {
			sortedNumbers[sortedCounter] = numbers[lowCounter];
			lowCounter++;
			sortedCounter++;
		}

		while (highCounter <= high) {
			sortedNumbers[sortedCounter] = numbers[highCounter];
			highCounter++;
			sortedCounter++;
		}
		int counter = low;
		for (int i = 0; i < sortedNumbers.length; i++) {
			numbers[counter] = sortedNumbers[i];
			counter++;
		}
	}

	public int[] sort() {
		if (numbers != null) {
			mergeSort(0, numbers.length - 1);
		}
		return numbers;
	}
}
