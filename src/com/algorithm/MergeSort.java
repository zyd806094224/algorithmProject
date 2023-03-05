package com.algorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{0,-1,3,7,9,4,5,2,3,1};
        mergeSort(nums,0,nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void mergeSort(int[] nums, int L, int R) {
        if (L >= R) return;
        int M = L + (R - L) / 2;
        mergeSort(nums, L, M);
        mergeSort(nums, M + 1, R);
        merge(nums, L, M, R);
    }

    private static void merge(int[] nums, int L, int M, int R) {
        int[] arr = new int[R - L + 1];
        int i = L;
        int j = M + 1;
        int index = 0;
        while (i <= M && j <= R) {
            if (nums[i] < nums[j]) {
                arr[index++] = nums[i++];
            } else {
                arr[index++] = nums[j++];
            }
        }
        while (i <= M) {
            arr[index++] = nums[i++];
        }
        while (j <= R) {
            arr[index++] = nums[j++];
        }
        for (int x = 0; x < arr.length; x++) {
            nums[x + L] = arr[x];
        }
    }
}
