package com.algorithm;

/**
 * 最长回文子串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "ababc";
        System.out.println(getLongestPalindrome(str));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param A string字符串
     * @return int整型
     */
    public static int getLongestPalindrome(String A) {
        // write code here
        boolean[][] dp = new boolean[A.length()][A.length()];
        int max = 1;
        for (int j = 1; j < A.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
        }
        return max;
    }
}
