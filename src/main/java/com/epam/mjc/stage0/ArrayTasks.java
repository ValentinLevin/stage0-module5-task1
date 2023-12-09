package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"winter", "spring", "summer", "autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i+1;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int result = 0;
        int length = arr.length;
        for (int i=0; i < length; i++) {
            result += arr[i];
        }
        return result;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (number == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        int length = arr.length;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[length-i-1] = arr[i];
        }
        return result;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        int positiveNumberCount = 0;
        for (int i = 0; i<length; i++) {
            if (arr[i] > 0) {
                positiveNumberCount++;
                result[positiveNumberCount-1] = arr[i];
            }
        }
        int[] positiveNumbers = new int[positiveNumberCount];
        System.arraycopy(result, 0, positiveNumbers, 0, positiveNumberCount);
        return positiveNumbers;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */

    public int[][] sortRaggedArray(int[][] arr) {
        int arrRowCount = arr.length;
        int arrMinItemCount = arr[0].length;
        int arrMaxItemCount = 0;

        for (int i = 0; i < arrRowCount; i++) {
            if (arrMaxItemCount < arr[i].length) {
                arrMaxItemCount = arr[i].length;
            }
            if (arrMinItemCount > arr[i].length) {
                arrMinItemCount = arr[i].length;
            }
        }

        int[][] result = new int[arrRowCount][];

        int searchedItemCount = arrMinItemCount;
        int resultRowCount = 0;
        while (searchedItemCount <= arrMaxItemCount) {
            for (int arrIndex = 0; arrIndex < arrRowCount; arrIndex++) {
                if (arr[arrIndex].length == searchedItemCount) {
                    resultRowCount++;
                    result[resultRowCount-1] = sort(arr[arrIndex]);
                }
            }
            searchedItemCount++;
        }

        return result;
    }

    public int[] sort(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        System.arraycopy(arr, 0, result, 0, length);
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int buf = arr[j];
                    result[j] = arr[j-1];
                    result[j-1] = buf;
                }
            }
        }
        return result;
    }
}
