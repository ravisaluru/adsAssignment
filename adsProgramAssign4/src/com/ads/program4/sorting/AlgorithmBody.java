package com.ads.program4.sorting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class AlgorithmBody {

	Integer[] dataInput;

	protected static final int INPUT_LOWER_CEILING = 0;
	protected static final int INPUT_SIZE_ONE_THOUSAND = 1000;
	protected static final int INPUT_SIZE_FIVE_THOUSAND = 5000;
	protected static final int INPUT_SIZE_TEN_THOUSAND = 10000;
	protected static final int INPUT_SIZE_FIFTY_THOUSAND = 50000;
	protected static final int INPUT_SIZE_HUNDRED_THOUSAND = 100000;
	protected static ArrayList<String> completeSummary;
	protected static String completeSummaryOfAllSortingTechniques;
	protected long startTimeInMilliSeconds = 0l;
	protected long endTImeInMilliSeconds = 0l;

	protected DecimalFormat format = new DecimalFormat("#.##");

	/**
	 * Implements the Sorting Algorithm Code
	 */
	protected abstract void sortingAlgorithm();

	/**
	 * Prints the Sorting Algorithm Output <li>Running Time of the Algorithm
	 */
	protected void printAlgorithmSummaryForCertainInput(int inputSize, long numberOfSwaps) {
		long totalTime = endTImeInMilliSeconds - startTimeInMilliSeconds;
		String output = new String();
		StringBuffer sb = new StringBuffer();
		if (totalTime > 60000) {
			totalTime = totalTime / 60000;
			sb.append("The time taken to sort the data input (" + format.format(inputSize)
					+ ") is =[" + format.format(totalTime) + "] in minutes");
			sb.append("The Number of Swaps used are =[" + numberOfSwaps + "]");
		} else if (totalTime > 1000) {
			totalTime = totalTime / 1000;
			sb.append("The time taken to sort the data input (" + format.format(inputSize)
					+ ") is =[" + format.format(totalTime) + "] in Seconds");
			sb.append("The Number of Swaps used are =[" + numberOfSwaps + "]");
		} else {
			sb.append("The time taken to sort the data input (" + format.format(inputSize)
					+ ") is =[" + format.format(totalTime) + "] in Milli Seconds");
			sb.append("The Number of Swaps used are =[" + numberOfSwaps + "]");
		}
		output = sb.toString();
		System.out.println(output);
		completeSummary.add(output);
	}

	/**
	 * Prints the complete Summary for the algorithm being used for All the
	 * inputs
	 *
	 * @param classObject
	 *            The Algorithm Class
	 */
	@SuppressWarnings("rawtypes")
	protected void appendToCompleteAlgorithmSummary(Class classObject) {
		if (isCompleteSummaryNotEmpty()) {
			Iterator<String> it = completeSummary.iterator();
			StringBuffer sb = new StringBuffer();
			sb.append("*********************************************************************************\n\n");
			sb.append("\t The complete Algorithm =[" + classObject.getName()
					+ "] summary for different types of input is as follows \n");
			while (it.hasNext()) {

				sb.append(it.next());
				sb.append("\n\n");
			}
			sb.append("*********************************************************************************\n\n");
			completeSummaryOfAllSortingTechniques = completeSummaryOfAllSortingTechniques
					+ sb.toString();
		}
	}

	protected boolean isCompleteSummaryNotEmpty() {
		return completeSummary != null;
	}

	protected Integer[] getRandomData(int upperBound) {
		try {
			Random random = new Random();
			Integer[] data = new Integer[upperBound];
			int counter = upperBound - 1;
			while (counter > -1) {
				data[counter] = random.nextInt(upperBound + 1);
				counter--;
			}
			return data;
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Oops, something went wrong, the error message =[" + ex.getMessage()
					+ "]");
			return null;
		}
	}
}
