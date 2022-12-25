package com.algorithm;

/**
 * JZ13 机器人的运动范围
 */
public class RangeOfMotionOfRobot {
    public static void main(String[] args) {
        System.out.println(movingCount(1, 2, 3));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int m = rows - 1;
        int n = cols - 1;
        boolean[][] dp = new boolean[rows][cols];
        process(0, 0, m, n, threshold, dp);
        return ans;
    }

    static int ans = 0;

    private static void process(int i, int j, int m, int n, int threshold, boolean[][] dp) {
        if (i < 0 || i > m || j < 0 || j > n || dp[i][j]) {
            return;
        }
        if (!accept(i, j, threshold)) {
            return;
        }
        ans++;
        dp[i][j] = true;
        process(i + 1, j, m, n, threshold, dp);
        process(i - 1, j, m, n, threshold, dp);
        process(i, j + 1, m, n, threshold, dp);
        process(i, j - 1, m, n, threshold, dp);
    }

    private static boolean accept(int i, int j, int threshold) {
        int count = 0;
        while (i > 0) {
            count = count + i % 10;
            i = i / 10;
        }
        while (j > 0) {
            count = count + j % 10;
            j = j / 10;
        }
        return count <= threshold;
    }
}
