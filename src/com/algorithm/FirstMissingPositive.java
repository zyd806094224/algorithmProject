package com.algorithm;

/**
 * 数组中第一个缺失的正数 leetcode41
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int val = nums[i];
            if (val > 0 && val <= nums.length && val != i + 1 && nums[val - 1] != val) {
                swap(nums, i, val - 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
