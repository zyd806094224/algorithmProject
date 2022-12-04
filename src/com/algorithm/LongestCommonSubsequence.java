package com.algorithm;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ca";
        String str2 = "bdcaaa";
        System.out.println(LCS(str1, str2));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * s1和s2最长公共子序列的长度
     *
     * @param s1 string字符串
     * @param s2 string字符串
     * @return int整型
     */
    public static String LCS(String s1, String s2) {
        // write code here
        if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1) {
            return "-1";
        }
        //任何一行或者任何一列没有字符 则公共子串长度必为0
        //dp表统计的是 s1 和 s2 所占字符的长度表
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {//第几行
            for (int j = 1; j < dp[0].length; j++) { //第几列
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int max = dp[s1.length()][s2.length()]; //公共子序列最大长度
        if(max == 0){
            return "-1";
        }
        int m = s1.length();
        int n = s2.length();
        char[] res = new char[max];
        while(max > 0){
            if(m >= 1 && dp[m][n] == dp[m - 1][n]){
                m--;
            }else if(n >= 1 && dp[m][n] == dp[m][n - 1]){
                n--;
            }else{
                res[--max] = s1.charAt(m - 1);
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }
}
