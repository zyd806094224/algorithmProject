package com.algorithm;

/**
 * str2 是否是 str1的子串  是的话 返回str2所在str1位置的起始下标
 */
public class KMP {

    public static void main(String[] args) {
        String str1 = "1234545645578";
        String str2 = "557";
        System.out.println(getIndexOf(str1, str2));
    }

    private static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2); //O(M)
        //O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) { // str2中比对的位置已经无法往前跳了
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // i1越界 或者 i2 越界了
        return i2 == str2.length ? i1 - i2 : -1;
    }

    // 获取字符串每个位置的最长前缀长度   abbsabbt :  t的最长前缀是 abb
    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1}; //人为规定
        }
        int[] next = new int[ms.length];
        next[0] = -1; //人为规定
        next[1] = 0; //认为规定
        int i = 2; //next数组的位置
        int cn = 0;  //有两个含义
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) { // 当前跳到cn位置的字符和i-1位置的字符匹配不上 ，  可以往前跳
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
