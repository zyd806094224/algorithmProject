package com.algorithm;

/**
 * 数字翻译成字符串
 */
public class NumberTranslationString {
    public static void main(String[] args) {
        System.out.println(solve("110111"));
    }

    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve(String nums) {
        // write code here
        return process(0, nums.toCharArray());
    }

    private static int process(int index, char[] charArray) {
        if (charArray == null || charArray[0] == '0') {
            return 0;
        }
        if (index >= charArray.length) {
            return 1;
        }
        int p1 = 0;
        if (charArray[index] > 0) {
            if (index == charArray.length - 1) {
                p1 = process(index + 1, charArray);
            } else {
                if (Integer.parseInt(String.valueOf(charArray[index + 1])) > 0) {
                    p1 = process(index + 1, charArray);
                }
            }
        }
        int p2 = 0;
        if (index < charArray.length - 1) {
            String str1 = String.valueOf(charArray[index]);
            String str2 = String.valueOf(charArray[index + 1]);
            int i = Integer.valueOf(str1 + str2);
            if (i <= 26) {
                if (index < charArray.length - 2) {
                    if (Integer.parseInt(String.valueOf(charArray[index + 2])) > 0) {
                        p2 = process(index + 2, charArray);
                    }
                } else {
                    p2 = process(index + 2, charArray);
                }
            }
        }
        return p1 + p2;
    }
}
