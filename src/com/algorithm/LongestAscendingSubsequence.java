package com.algorithm;

/**
 * 最长上升子序列
 */
public class LongestAscendingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 1, 5, 2, 3, 7};
        System.out.println(LIS(arr));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定数组的最长严格上升子序列的长度。
     *
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public static int LIS(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        int[] dp = new int[arr.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }
            dp[i] = 1 + tempMax;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
