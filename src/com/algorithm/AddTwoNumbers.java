package com.algorithm;

/**
 * 不用+、-、*、/ 运算符实现加法
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(189, 24));
    }

    private static int addTwoNumbers(int a, int b) {
        int res = 0;
        int ans = 0;
        do {
            res = a ^ b; //异或的本质就是无进位两数相加
            ans = (a & b) << 1;
            a = res;
            b = ans;
        } while (ans != 0);
        return res;
    }
}
