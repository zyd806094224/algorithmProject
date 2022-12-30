package com.algorithm;

import java.util.HashMap;

/**
 * 字符串的排列
 * s1 的排列之一是 s2 的 子串 Leetcode 567
 *
 * 滑动窗口+hash思路
 */
public class ArrangementOfStrings {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int index = 0;
        for (int i = 0; i < len1; i++, index++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len1; i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        while (index < len2) {
            if (map1.equals(map2)) {
                return true;
            }
            char before = s2.charAt(index - len1);
            char after = s2.charAt(index);
            map2.put(before, map2.get(before) - 1);
            if (map2.get(before) == 0) {
                map2.remove(before);
            }
            map2.put(after, map2.getOrDefault(after, 0) + 1);
            index++;
        }
        return map1.equals(map2);
    }
}
