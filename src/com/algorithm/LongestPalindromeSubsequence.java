package com.algorithm;

/**
 * 最长回文字序列
 * i...j范围段上的 动态规划
 */
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String str = "abccsb";
        System.out.println(longestPalindromeSubSeq(str));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string 一个字符串由小写字母构成，长度小于5000
     * @return int
     */
    public static int longestPalindromeSubSeq(String s) {
        // write code here
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;  //自己和自己必回文 长度为1
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
