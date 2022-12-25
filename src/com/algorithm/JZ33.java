package com.algorithm;

/**
 * 二叉搜索树的后序遍历序列
 */
public class JZ33 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,6,9,11,10,8};
        System.out.println(verifySquenceOfBST(arr));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return process(sequence, 0, sequence.length - 1);
    }

    private static boolean process(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int currIndex = first;
        while (sequence[currIndex] < rootVal) {
            currIndex++;
        }
        int m = currIndex;
        while (sequence[currIndex] > rootVal) {
            currIndex++;
        }
        return currIndex == last && process(sequence, first, m - 1) && process(sequence, m, last - 1);
    }
}
