package com.algorithm;

/**
 * 在一个m\times nm×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 如输入这样的一个二维数组，
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 那么路径 1→3→5→2→1 可以拿到最多价值的礼物，价值为12
 */
public class TheGreatestValueOfGifts {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(maxValue(arr));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public static int maxValue(int[][] grid) {
        // write code here
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
