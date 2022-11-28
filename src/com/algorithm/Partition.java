package com.algorithm;

/**
 * 荷兰国旗问题
 */
public class Partition {

    public static void main(String[] args) {
        int[] arr = new int[]{34, 23, 1, 5, 6, 4, 87, 0, -2, 5};
        partition(arr, 0, arr.length - 1, arr[arr.length - 1]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void partition(int[] arr, int L, int R, int P) {
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
    }

    private static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }

}
