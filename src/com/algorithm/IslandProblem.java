package com.algorithm;

/**
 * 岛屿问题
 */
public class IslandProblem {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 0}};
        System.out.println(islandNums(m));
    }

    private static int islandNums(int[][] m) {
        int N = m[0].length;
        int M = m.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    /**
     * 定义一个感染过程
     *
     * @param m
     * @param i
     * @param j
     * @param N
     * @param M
     */
    private static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || j < 0 || i > N - 1 || j > M - 1 || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j, N, M);
        infect(m, i + 1, j, N, M);
        infect(m, i, j - 1, N, M);
        infect(m, i, j + 1, N, M);
    }
}
