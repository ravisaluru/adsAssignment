/**
 *
 */
package com.ads.program4.sorting;

import java.util.Arrays;

/**
 * @author Ravi
 *
 */
public class Quicksort extends AlgorithmBody {
	private int inputSize;
	private static Integer pivot;
	private static int CUTOFF = 10;
	private static long numberOfSwaps = 0l;

	public int getInputSize() {
		return inputSize;
	}

	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}

	public void sorting() {
		sortingAlgorithm();
	}

	public void getInputData() {
		this.dataInput = super.getRandomData(this.getInputSize());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ads.program4.sorting.AlgorithmBody#sortingAlgorithm()
	 */
	@Override
	protected void sortingAlgorithm() {
		startTimeInMilliSeconds = System.currentTimeMillis();
		Integer[] items = this.dataInput;
		quicksort(items, 0, items.length - 1);
		endTImeInMilliSeconds = System.currentTimeMillis();
		printAlgorithmSummaryForCertainInput(this.inputSize, numberOfSwaps);
	}

	/**
	 * @param items
	 */
	private void quicksort(Integer[] items, int left, int right) {
		{
			if (left + CUTOFF <= right) {
				pivot = median3(items, left, right);

				// Begin partitioning
				int i = left + 1;
				int j = right;
				for (;;) {
					while (items[i].compareTo(pivot) < 0) {
						i++;
					}
					while (items[j].compareTo(pivot) > 0) {
						j--;
					}
					if (i < j) {
						numberOfSwaps++;
						swapReferences(items, i, j);
					} else {
						break;
					}
				}

				numberOfSwaps++;
				swapReferences(items, i, right - 1); // Restore pivot

				quicksort(items, left, i - 1); // Sort small elements
				quicksort(items, i + 1, right); // Sort large elements
			} else {
				insertionSort(items, left, right);
			}
		}
	}

	private static void swapReferences(Integer[] items, int i, int j) {

		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	private static void insertionSort(Integer[] items, int left, int right) {

		Integer[] arrayToSort = Arrays.copyOfRange(items, left, right);
		int j;
		for (int p = 1; p < arrayToSort.length; p++) {
			Integer tmp = arrayToSort[p];
			for (j = p; j > 0 && tmp.compareTo(arrayToSort[j - 1]) < 0; j--) {
				numberOfSwaps++;
				arrayToSort[j] = arrayToSort[j - 1];
			}
			arrayToSort[j] = tmp;
		}
	}

	private static Integer median3(Integer[] items, int left, int right) {
		int center = (left + right) / 2;
		if (items[center].compareTo(items[left]) < 0) {
			numberOfSwaps++;
			swapReferences(items, left, center);
		}
		if (items[right].compareTo(items[left]) < 0) {
			numberOfSwaps++;
			swapReferences(items, left, right);
		}
		if (items[right].compareTo(items[center]) < 0) {
			numberOfSwaps++;
			swapReferences(items, center, right);
		}

		// Place pivot at position right - 1
		numberOfSwaps++;
		swapReferences(items, center, right - 1);
		return items[right - 1];
	}
}
