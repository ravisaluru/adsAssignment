package com.ads.program4.sorting;

public class InsertionSort extends AlgorithmBody {

	private int inputSize;

	public void sorting() {
		sortingAlgorithm();
	}

	@Override
	protected void sortingAlgorithm() {
		// TODO Auto-generated method stub
		Integer[] input = this.dataInput;
		startTimeInMilliSeconds = System.currentTimeMillis();
		int j;
		long numberOfSwaps = 0;
		for (int p = 1; p < input.length; p++) {
			Integer tmp = input[p];
			for (j = p; j > 0 && tmp.compareTo(input[j - 1]) < 0; j--) {
				numberOfSwaps++;
				input[j] = input[j - 1];
			}
			input[j] = tmp;
		}
		endTImeInMilliSeconds = System.currentTimeMillis();
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

}
