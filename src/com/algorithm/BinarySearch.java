package com.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,8,9,13,68,100};
        System.out.println(find(arr, 88));
    }


    private static int find(int[] arr, int x) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
