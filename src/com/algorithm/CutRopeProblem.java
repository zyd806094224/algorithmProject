package com.algorithm;

/**
 * 割绳子问题
 */
public class CutRopeProblem {

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

    private static int cutRope(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        int max = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], i);
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (i - j) * dp[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
