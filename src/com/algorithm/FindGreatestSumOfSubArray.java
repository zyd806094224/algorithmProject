package com.algorithm;

/**
 * 连续子数组最长最大和
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,-3,4,-1,1,-3,2};
        for (int i : FindGreatestSumOfSubArray(arr)) {
            System.out.print(i + ",");
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindGreatestSumOfSubArray(int[] array) {
        // write code here
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
            if (dp[i] >= max) {
                max = dp[i];
                index = i;
            }
        }
        int temp = 0;
        if (index != 0) {
            int leftIndex = 0;
            for (int i = index; i >= 0; i--) {
                temp = temp + array[i];
                if (temp == max) {
                    leftIndex = i;
                }
            }
            int[] res = new int[index - leftIndex + 1];
            for (int i = leftIndex; i <= index; i++) {
                res[i - leftIndex] = array[i];
            }
            return res;
        } else {
            return new int[]{array[0]};
        }
    }
}
