package com.example.week6test;

public class MergeSort {

    private int length;
    private int[] array;
    private int[] arrayTemp;

    public static void main(String args[]) {

        int[] arrayInput = {17, 5, 23, 42, 69, 78, 6, 2, 9, 34, 56, 67, 13, 19, 4, 1, 99, 18, 7, 80};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arrayInput);
        for (int i = 0; i < arrayInput.length; i++) {
            System.out.print(arrayInput[i] + " ");
        }
    }

    private void sort(int arrayInput[]) {
        this.array = arrayInput;
        this.length = arrayInput.length;
        this.arrayTemp = new int[length];
        mergeSort(0, length - 1);
    }

    private void mergeSort(int lowerBound, int upperBound) {

        if (lowerBound < upperBound) {
            int split = lowerBound + (upperBound - lowerBound) / 2;
            // Below step sorts the left side of the array
            mergeSort(lowerBound, split);
            // Below step sorts the right side of the array
            mergeSort(split + 1, upperBound);
            // Now merge both sides
            mergeParts(lowerBound, split, upperBound);
        }
    }

    private void mergeParts(int lowerBound, int split, int upperBound) {

        for (int i = lowerBound; i <= upperBound; i++) {
            arrayTemp[i] = array[i];
        }
        int low1 = lowerBound;
        int spl = split + 1;
        int low2 = lowerBound;
        while (low1 <= split && spl <= upperBound) {
            if (arrayTemp[low1] <= arrayTemp[spl]) {
                array[low2] = arrayTemp[low1];
                low1++;
            } else {
                array[low2] = arrayTemp[spl];
                spl++;
            }
            low2++;
        }
        while (low1 <= split) {
            array[low2] = arrayTemp[low1];
            low2++;
            low1++;
        }

    }
}
