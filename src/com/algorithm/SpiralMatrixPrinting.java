package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵打印
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrixPrinting {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; //行数
        int n = matrix[0].length;//列数
        int numSize = m * n;
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int right = 0;
        int bottom = n - 1;
        int left = m - 1;
        a:
        while (true) {
            int tempTop = top;
            while (tempTop <= bottom) {
                ans.add(matrix[right][tempTop++]);
                if (ans.size() == numSize) {
                    break a;
                }
            }
            top++;
            right++;
            int tempRight = right;
            while (tempRight <= left) {
                ans.add(matrix[tempRight++][bottom]);
                if (ans.size() == numSize) {
                    break a;
                }
            }
            bottom--;
            int tempBottom = bottom;
            while (tempBottom >= top - 1) {
                ans.add(matrix[left][tempBottom--]);
                if (ans.size() == numSize) {
                    break a;
                }
            }
            left--;
            int tempLeft = left;
            while (tempLeft >= right) {
                ans.add(matrix[tempLeft--][top - 1]);
                if (ans.size() == numSize) {
                    break a;
                }
            }

        }
        return ans;
    }
}
