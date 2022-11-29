package com.algorithm;

/**
 * 机器人从M点出发到P点，走K步的方案数问题
 */
public class RobotWalking {

    public static void main(String[] args) {
        // 1 2 3 4 5       N=5 M=3 P=2 K=3
        System.out.println(ways(5, 3, 2, 23));
    }

    private static int ways(int N, int M, int P, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return walk(N, M, K, P, dp);
    }

    private static int walk(int N, int curr, int rest, int P, int[][] dp) {
        if (dp[curr][rest] != -1) {
            return dp[curr][rest];
        }
        if (rest == 0) {
            dp[curr][rest] = curr == P ? 1 : 0;
            return dp[curr][rest];
        }
        if (curr == 1) {
            dp[curr][rest] = walk(N, 2, rest - 1, P, dp);
            return dp[curr][rest];
        }
        if (curr == N) {
            dp[curr][rest] = walk(N, N - 1, rest - 1, P, dp);
            return dp[curr][rest];
        }
        dp[curr][rest] = walk(N, curr - 1, rest - 1, P, dp) + walk(N, curr + 1, rest - 1, P, dp);
        return dp[curr][rest];
    }

}
