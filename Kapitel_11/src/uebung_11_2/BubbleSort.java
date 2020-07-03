package uebung_11_2;

public class BubbleSort {

	public BubbleSort() {

	}

	// The bubbleSort algorithm
	public void bubbleSort(int numbers[]) {
		boolean finished = true;
		for (int i = 0; i < numbers.length; i++) {
			finished = true;
			for (int j = 0; j < numbers.length - i; j++) {
				if ((j + 1) < numbers.length) {
					if (numbers[j + 1] < numbers[j]) {
						finished = false;
						int temp = numbers[j];
						numbers[j] = numbers[j + 1];
						numbers[j + 1] = temp;
					}
				}
			}
			if (finished) {
				break;
			}
		}
	}
}
