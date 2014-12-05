package com.ads.program4.sorting;

import java.util.Arrays;

public class Heapsort extends AlgorithmBody {

	private int inputSize;
	private static long numberOfSwaps = 0l;
	private static Integer[] sortedArray;

	public int getInputSize() {
		return inputSize;
	}

	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}

	@Override
	protected void sortingAlgorithm() {
		startTimeInMilliSeconds = System.currentTimeMillis();
		Integer[] items = this.dataInput;
		sortedArray = new Integer[items.length];
		heapsort(items);
		endTImeInMilliSeconds = System.currentTimeMillis();
		printAlgorithmSummaryForCertainInput(this.inputSize, numberOfSwaps);

	}

	public void sorting() {
		sortingAlgorithm();
	}

	public void getInputData() {
		this.dataInput = super.getRandomData(this.getInputSize());
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	private static void percDown(Integer[] items, int i, int n) {
		int child;
		Integer tmp;

		for (tmp = items[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && items[child].compareTo(items[child + 1]) < 0) {
				child++;
			}
			if (tmp.compareTo(items[child]) < 0) {
				numberOfSwaps++;
				items[i] = items[child];
			} else {
				break;
			}
		}
		items[i] = tmp;
	}

	public static void heapsort(Integer[] items) {
		for (int i = items.length / 2 - 1; i >= 0; i--) {
			percDown(items, i, items.length);
		}
		int j = 0;
		for (int i = items.length - 1; i > 0; i--) {
			numberOfSwaps++;
			sortedArray[j] = swapReferences(items, 0, i); /* deleteMax */
			j++;
			percDown(items, 0, i);
		}
	}

	private static Integer swapReferences(Integer[] items, int i, int i2) {
		Integer[] tempArray = items;
		Integer tmp = tempArray[i];
		tempArray[i] = tempArray[i2];
		tempArray[i2] = tmp;
		int size = items.length;
		items = new Integer[--size];
		items = Arrays.copyOf(tempArray, size);
		return tmp;
	}
}
