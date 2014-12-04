package com.ads.program4.sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortingUtilityMethods {

	protected static void performInsertSort() {

		InsertionSort insertionSort = new InsertionSort();
		processForVariousInputs(insertionSort, AlgorithmBody.INPUT_SIZE_ONE_THOUSAND);
		insertionSort.appendToCompleteAlgorithmSummary(insertionSort.getClass());
	}

	protected static void performShellSort() {
		Shellsort shellSort = new Shellsort();
		processForVariousInputs(shellSort, AlgorithmBody.INPUT_SIZE_ONE_THOUSAND);
		shellSort.appendToCompleteAlgorithmSummary(shellSort.getClass());
	}

	protected static void performQuickSort() {
		Quicksort quickSort = new Quicksort();
		processForVariousInputs(quickSort, AlgorithmBody.INPUT_SIZE_ONE_THOUSAND);
		quickSort.appendToCompleteAlgorithmSummary(quickSort.getClass());
	}

	protected static void processForVariousInputs(Object classObject, int input) {
		int operation = input;

		switch (operation) {
		case AlgorithmBody.INPUT_SIZE_ONE_THOUSAND:
			performOperationForInputSize(classObject, AlgorithmBody.INPUT_SIZE_ONE_THOUSAND);
			operation = AlgorithmBody.INPUT_SIZE_FIVE_THOUSAND;
			processForVariousInputs(classObject, operation);
			break;
		case AlgorithmBody.INPUT_SIZE_FIVE_THOUSAND:
			performOperationForInputSize(classObject, AlgorithmBody.INPUT_SIZE_FIVE_THOUSAND);
			operation = AlgorithmBody.INPUT_SIZE_TEN_THOUSAND;
			processForVariousInputs(classObject, operation);
			break;
		case AlgorithmBody.INPUT_SIZE_TEN_THOUSAND:
			performOperationForInputSize(classObject, AlgorithmBody.INPUT_SIZE_TEN_THOUSAND);
			operation = AlgorithmBody.INPUT_SIZE_FIFTY_THOUSAND;
			processForVariousInputs(classObject, operation);
			break;
		case AlgorithmBody.INPUT_SIZE_FIFTY_THOUSAND:
			performOperationForInputSize(classObject, AlgorithmBody.INPUT_SIZE_FIFTY_THOUSAND);
			operation = AlgorithmBody.INPUT_SIZE_HUNDRED_THOUSAND;
			processForVariousInputs(classObject, operation);
			break;
		case AlgorithmBody.INPUT_SIZE_HUNDRED_THOUSAND:
			performOperationForInputSize(classObject, AlgorithmBody.INPUT_SIZE_HUNDRED_THOUSAND);
			operation = 0;
			processForVariousInputs(classObject, operation);
			break;
		case 0:
			break;
		default:
			System.out.println("Oops, something went wrong! Please debug to fix the bug!");
		}
	}

	private static void performOperationForInputSize(Object classObject, int input) {

		try {
			Method setMethod = getClassMethod(classObject, "setInputSize", int.class);
			invoke(classObject, setMethod, input);

			Method getInputData = getClassMethod(classObject, "getInputData", null);
			invoke(classObject, getInputData, null);

			Method sortingMethod = getClassMethod(classObject, "sorting", null);
			invoke(classObject, sortingMethod, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void invoke(Object classObject, Method method, Integer input)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (input == null) {
			method.invoke(classObject, null);
		} else {
			method.invoke(classObject, input);
		}
	}

	protected static Method getClassMethod(Object classObject, String methodName, Class className)
			throws NoSuchMethodException, SecurityException {
		return className != null ? classObject.getClass().getMethod(methodName, className)
				: classObject.getClass().getMethod(methodName, null);
	}

}
