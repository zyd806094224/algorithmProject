package com.algorithm;

import java.util.HashMap;

/**
 * 最小覆盖子串 leetcode 76
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int tLen = t.length();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int currLen = Integer.MAX_VALUE;
        int minLen = currLen;
        int ansLeft = -1;
        int ansRight = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            }
            while (right - left + 1 >= tLen && check(tMap, sMap)) {
                currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    ansLeft = left;
                    ansRight = right;
                }
                char c1 = s.charAt(left);
                if (tMap.containsKey(c1)) {
                    sMap.put(c1, sMap.get(c1) - 1);
                }
                left++;
            }
            right++;
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private static boolean check(HashMap<Character, Integer> tMap, HashMap<Character, Integer> map) {
        for (char c : tMap.keySet()) {
            if (map.containsKey(c) && map.get(c) >= tMap.get(c)) {

            } else {
                return false;
            }
        }
        return true;
    }
}
