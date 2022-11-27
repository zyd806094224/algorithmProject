package com.algorithm;

import java.util.Arrays;

/**
 * 最小的K个数
 */
public class MinKNums {

    public static void main(String[] args) {
        int[] arr = new int[]{34,2,56,1,3,65,-2,21,32,5};
        int[] leastNumbers = getLeastNumbers(arr, 3);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            return new int[]{};
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

    public static int[] quickSort(int[] arr, int L, int R, int k) {
        int[] partition = partition(arr, L, R, arr[R]);
        if (partition[0] + 1 == k) {
            return Arrays.copyOf(arr, k);
        }
        if (partition[0] + 1 > k) {
            return quickSort(arr, L, partition[0] - 1, k);
        } else {
            return quickSort(arr, partition[0] + 1, R, k);
        }
    }

    public static int[] partition(int[] arr, int L, int R, int P) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] > P) {
                swap(arr, L, --more);
            } else if (arr[L] < P) {
                swap(arr, L++, ++less);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
