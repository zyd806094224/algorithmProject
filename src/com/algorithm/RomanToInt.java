package com.algorithm;

import java.util.HashMap;

/**
 * 罗马数字转整数
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    public static int romanToInt(String s) {
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < charArr.length - 1; i++) {
            if (map.get(charArr[i]) < map.get(charArr[i + 1])) {
                res -= map.get(charArr[i]);
            } else {
                res += map.get(charArr[i]);
            }
        }
        res += map.get(charArr[charArr.length - 1]);
        return res;
    }
}
