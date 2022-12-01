package com.algorithm;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weight = new int[]{20,10,10,30,40};
        int[] value = new int[]{100,20,50,40,70};
        int bag = 30;
        System.out.println(getMaxValue(weight, value, 0, 0, bag));
        System.out.println(dpWays(weight, value, bag));
    }

    private static int getMaxValue(int[] w,int[] v,int index,int alreadyW,int bag){
        return process(w,v,index,alreadyW,bag);
    }

    private static int process(int[] w,int[] v,int index,int alreadyW,int bag){
        if(alreadyW > bag){
            return -1;
        }
        //重量没超
        if(index == w.length){
            return 0;
        }
        int p1 = process(w,v,index + 1,alreadyW,bag);
        int p2 = -1;
        int p2Next = process(w,v,index + 1,alreadyW + w[index],bag);
        if(p2Next != -1){
            p2 = v[index] + p2Next;
        }
        return Math.max(p1,p2);
    }

    private static int dpWays(int[] w,int[] v,int bag){
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        //dp[N][...] = 0
        for (int index = N - 1; index >= 0; index--) {
            for(int rest = 0;rest <= bag;rest++){
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if(rest - w[index] >= 0){ //包剩余的空间减去当前物品的重量大于等于0 说明当前物品装入包内是有效解
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }


}
