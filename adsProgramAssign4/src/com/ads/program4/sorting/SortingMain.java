package com.ads.program4.sorting;

import java.util.Scanner;

public class SortingMain {
	protected static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer choice = 5;
		while (choice != null) {
			switch (choice) {
			case 1:
				SortingUtilityMethods.performInsertSort();
				choice = 5;
				break;
			case 2:
				SortingUtilityMethods.performShellSort();
				choice = 5;
				break;
			case 5:
				System.out.println(getWelcomeMessage());
				choice = getUserInput();
				if (choice == null) {
					getUserInput();
				}
				break;
			default:
				System.out.println("Wrong option");
				choice = 5;
				break;
			}
		}
		System.out.println("Exit");
	}

	private static Integer getUserInput() {
		if (scan.hasNextInt()) {
			int choice = scan.nextInt();
			return choice;
		} else {
			return null;
		}
	}

	protected static String getWelcomeMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append("Please select the sorting Algorithm you want to analyze");
		sb.append(getNewLine());
		sb.append("1. Insertion Sort");
		sb.append(getNewLine());
		sb.append("2. Shellsort");
		sb.append(getNewLine());
		sb.append("3. Heapsort");
		sb.append(getNewLine());
		sb.append("4. Quicksort");
		sb.append(getNewLine());
		sb.append("Please enter 1 for Insertion sort, or 2 for Shellsort, or 3 for Heapsort, or 4 for Quicksort");
		return sb.toString();
	}

	static String getNewLine() {
		return "\n";
	}

}
