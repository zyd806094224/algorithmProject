package com.algorithm;

/**
 * 最长公共子串
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "abc23sdfge";
        String str2 = "ewbc23dsagsdfhjn";
        System.out.println(LCS(str1, str2));
    }

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length()][str2.length()];
        if (str1.charAt(0) == str2.charAt(0)) {
            dp[0][0] = 1;
        }
        int index = 0;
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) {
                        index = i;
                        max = dp[i][j];
                    }
                }
            }
        }
        if (max > 0) {
            return str1.substring(index - max + 1, index + 1);
        }
        return "";
    }
}
