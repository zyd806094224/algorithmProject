package com.algorithm;

/**
 * 整数转罗马数字 leetcode12
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(199));
    }

    public static String intToRoman(int num) {
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] key = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num = num - value[i];
                sb.append(key[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
