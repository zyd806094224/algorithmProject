package com.algorithm;

/**
 * 第N个丑数
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(getUglyNumber(7));
    }

    private static int getUglyNumber(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[1] = 1;  //第一个丑数规定是1
        int index1 = 1;
        int index2 = 1;
        int index3 = 1;
        for (int i = 2; i <= N; i++) { //从第二个丑数开始递增找
            dp[i] = Math.min(2 * dp[index1], Math.min(3 * dp[index2], 5 * dp[index3]));
            if (2 * dp[index1] == dp[i]) {
                index1++;
            }
            if (3 * dp[index2] == dp[i]) {
                index2++;
            }
            if (5 * dp[index3] == dp[i]) {
                index3++;
            }
        }
        return dp[N];
    }

}
