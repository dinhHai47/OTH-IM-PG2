package uebung_11_2;

import java.util.Arrays;

public class MergeSort {

	public MergeSort() {

	}

	/*
	 * Divide and conquer: The number-array is divided by half as long as it contains more then one number.
	 */
	public int[] mergeSort(int numbers[]) {
		if (numbers.length > 1) {
			int firstHalf[] = new int[numbers.length / 2];
			int secondHalf[] = new int[numbers.length / 2];
			firstHalf = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
			secondHalf = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
			firstHalf = mergeSort(firstHalf);
			secondHalf = mergeSort(secondHalf);
			return merge(firstHalf, secondHalf);
		}
		else {
			return numbers;
		}
	}

	//Merge the two sorted arrays in in sorted array and return it.
	private int[] merge(int left[], int right[]) {
		int leftCounter = 0;
		int rightCounter = 0;
		int sortedCounter = 0;
		int sorted[] = new int[left.length + right.length];

		while (leftCounter < left.length && rightCounter < right.length) {
			if (left[leftCounter] <= right[rightCounter]) {
				sorted[sortedCounter] = left[leftCounter];
				sortedCounter++;
				leftCounter++;
			}
			else {
				sorted[sortedCounter] = right[rightCounter];
				sortedCounter++;
				rightCounter++;
			}
		}

		if (leftCounter == left.length) {
			for (int i = rightCounter; i < right.length; i++) {
				sorted[sortedCounter] = right[i];
				sortedCounter++;
			}
		}

		else {
			for (int i = leftCounter; i < left.length; i++) {
				sorted[sortedCounter] = left[i];
				sortedCounter++;
			}
		}

		return sorted;
	}
}
