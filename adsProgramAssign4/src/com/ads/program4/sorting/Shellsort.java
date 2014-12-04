package com.ads.program4.sorting;

public class Shellsort extends AlgorithmBody {

	private int inputSize;

	@Override
	protected void sortingAlgorithm() {

		Integer[] input = this.dataInput;
		startTimeInMilliSeconds = System.currentTimeMillis();
		int j;
		long numberOfSwaps = 0;
		for (int gap = input.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < input.length; i++) {
				Integer tmp = input[i];
				for (j = i; j > 0 && tmp.compareTo(input[j - 1]) < 0; j--) {
					numberOfSwaps++;
					input[j] = input[j - 1];
				}
				input[j] = tmp;
			}
			endTImeInMilliSeconds = System.currentTimeMillis();
		}
		printAlgorithmSummaryForCertainInput(this.inputSize, numberOfSwaps);
	}

	public void getInputData() {
		this.dataInput = super.getRandomData(this.getInputSize());
	}

	public int getInputSize() {
		return inputSize;
	}

	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}

	public void sorting() {
		sortingAlgorithm();
	}

}
