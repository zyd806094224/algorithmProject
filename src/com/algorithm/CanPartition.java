package com.algorithm;

/**
 * 分割等和子集 leetcode416
 * 01背包问题
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        int len = nums.length;
        int[][] dp = new int[len + 1][half + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j <= half; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[len][half] == half;
    }
}
