/**
 *
 */
package com.ads.program4.sorting;

/**
 * @author Ravi
 *
 */
public class Mergesort extends AlgorithmBody {

	private int inputSize;
	private static long numberOfSwapsInMergeSort = 0l;

	public int getInputSize() {
		return inputSize;
	}

	public void getInputData() {
		this.dataInput = super.getRandomData(this.getInputSize());
	}

	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}

	public void sorting() {
		sortingAlgorithm();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.ads.program4.sorting.AlgorithmBody#sortingAlgorithm()
	 */
	@Override
	protected void sortingAlgorithm() {
		startTimeInMilliSeconds = System.currentTimeMillis();
		mergeSort(this.dataInput);
		endTImeInMilliSeconds = System.currentTimeMillis();
		printAlgorithmSummaryForCertainInput(this.getInputSize(), numberOfSwapsInMergeSort);
	}

	private static void mergeSort(Integer[] input, Integer[] tmpArray, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(input, tmpArray, left, center);
			mergeSort(input, tmpArray, center + 1, right);
			merge(input, tmpArray, left, center + 1, right);
		}
	}

	/**
	 * Mergesort algorithm.
	 *
	 * @param a
	 *            an array of Comparable items.
	 */
	public static void mergeSort(Integer[] input) {
		Integer[] tmpArray = new Integer[input.length];
		mergeSort(input, tmpArray, 0, input.length - 1);
	}

	private static void merge(Integer[] input, Integer[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (input[leftPos].compareTo(input[rightPos]) <= 0) {
				numberOfSwapsInMergeSort++;
				tmpArray[tmpPos++] = input[leftPos++];
			} else {
				tmpArray[tmpPos++] = input[rightPos++];
				numberOfSwapsInMergeSort++;
			}
		}

		while (leftPos <= leftEnd) {
			numberOfSwapsInMergeSort++;
			tmpArray[tmpPos++] = input[leftPos++];
		}

		while (rightPos <= rightEnd) {
			numberOfSwapsInMergeSort++;
			tmpArray[tmpPos++] = input[rightPos++];
		}

		// Copy tmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--) {
			input[rightEnd] = tmpArray[rightEnd];
		}
	}

}
