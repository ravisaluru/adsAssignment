/**
 *
 */
package com.ads.program4.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi
 *
 */
public class Quicksort extends AlgorithmBody {
	private int inputSize;

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
		List<Integer> items = new ArrayList<Integer>();
		items = getListFromDataInput();
		startTimeInMilliSeconds = System.currentTimeMillis();
		sort(items);
		endTImeInMilliSeconds = System.currentTimeMillis();
		printAlgorithmSummaryForCertainInput(this.inputSize, 0l);
	}

	private List<Integer> getListFromDataInput() {
		Integer[] data = this.dataInput;
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : data) {
			list.add(integer);
		}
		return list;
	}

	/**
	 * @param items
	 */
	private void sort(List<Integer> items) {
		if (items.size() > 1) {
			List<Integer> smaller = new ArrayList<>();
			List<Integer> same = new ArrayList<>();
			List<Integer> larger = new ArrayList<>();

			Integer chosenItem = items.get(items.size() / 2);
			for (Integer i : items) {
				if (i < chosenItem) {
					smaller.add(i);
				} else if (i > chosenItem) {
					larger.add(i);
				} else {
					same.add(i);
				}
			}

			sort(smaller); // Recursive call!
			sort(larger); // Recursive call!

			items.clear();
			items.addAll(smaller);
			items.addAll(same);
			items.addAll(larger);
		}

	}
}
