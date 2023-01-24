package com.algorithm;

/**
 * LeetCode 36
 */
public class IsValidSudoku {


    /**
     * 是有效的数独
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10]; //每行
        boolean[][] col = new boolean[9][10]; //每列
        boolean[][] bucket = new boolean[9][10]; //每个桶
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bid = 3 * (i / 3) + (j / 3); //对应的哪个桶？
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || bucket[bid][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
        return true;
    }
}
