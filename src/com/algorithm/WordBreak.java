package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拆分 leetcode139
 * 动态规划
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; //dp[i]表示从0开始对应的长度的字符是否成功匹配成功，最终返回dp[s.length()]
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
