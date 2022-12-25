package com.algorithm;

/**
 * 字符串转换为整数
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(strToInt("   -433 5235  sdadw"));
    }

    public static int strToInt(String s) {
        // write code here
        s = s.trim();
        if (s.equals("") || ((s.charAt(0) < '0' || s.charAt(0) > '9') &&
                s.charAt(0) != '+' && s.charAt(0) != '-')) {
            return 0;
        }
        int index = 0;
        int res = 0;
        boolean over = false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
        }
        while (index < s.length()) {
            if (s.charAt(index) > '9' || s.charAt(index) < '0') {
                break;
            } else {
                res = res * 10 + s.charAt(index++) - '0';
                if (res < 0) {
                    over = true;
                    break;
                }
            }
        }
        if (over) {
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            return s.charAt(0) == '-' ? -1 * res : res;
        }
    }
}
