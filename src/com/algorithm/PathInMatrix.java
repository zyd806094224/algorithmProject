package com.algorithm;

/**
 * 矩阵中的路径  路径是否存在某个字符串
 */
public class PathInMatrix {
    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}};
//        System.out.println(hasPath(matrix, "abcced"));
        System.out.println(hasPath(matrix, "see"));
    }

    public static boolean hasPath(char[][] matrix, String word) {
        // write code here
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    if (process(matrix, i, j, m, n, 0, word, dp)) {
                        return true;
                    }
//                    return process(matrix, i, j, m, n, 0, word, dp); //此种写法递归有问题
                }
            }
        }
        return false;
    }

    private static boolean process(char[][] matrix, int i, int j, int m, int n, int index, String word, boolean[][] dp) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > m || j > n || dp[i][j]) {
            return false;
        }
        if (word.charAt(index) != matrix[i][j]) {
            return false;
        }
        dp[i][j] = true;
        boolean b1 = process(matrix, i + 1, j, m, n, index + 1, word, dp);
        boolean b2 = process(matrix, i - 1, j, m, n, index + 1, word, dp);
        boolean b3 = process(matrix, i, j + 1, m, n, index + 1, word, dp);
        boolean b4 = process(matrix, i, j - 1, m, n, index + 1, word, dp);
        dp[i][j] = false;

        return b1 || b2 || b3 || b4;
    }
}
