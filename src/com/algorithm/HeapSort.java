package com.algorithm;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 56, -1, 2, 3, 6, 0, 22};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void heapSort(int[] nums) {
        int n = nums.length;
        //建堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
        //排序
        for (int i = n - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int leftSon = 2 * i + 1;
        int rightSon = 2 * i + 2;
        if (leftSon < n && nums[leftSon] > nums[largest]) {
            largest = leftSon;
        }
        if (rightSon < n && nums[rightSon] > nums[largest]) {
            largest = rightSon;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, n, largest);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
