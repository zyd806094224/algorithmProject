package com.algorithm;

/**
 * 最后一块石头重量II  leetcode1049
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int x : stones) {
            sum += x;
        }
        int half = sum / 2;
        int len = stones.length;
        int[][] dp = new int[len + 1][half + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j <= half; j++) {
                if (stones[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i - 1] + dp[i - 1][j - stones[i - 1]]);
                }
            }
        }
        return sum - dp[len][half] - dp[len][half];
    }
}
