package com.algorithm;

/**
 * 汉诺塔问题
 */
public class HanOTaProblem {

    public static void main(String[] args) {
        hanota(3,"左","右","中");
    }

    private static void hanota(int N,String start,String end,String other){
        if(N == 1){//只有一个数了，start移动到end结束
            System.out.println("move 1 from" + start + "---->" + end);
            return;
        }
        //把N - 1个从start移动到other
        hanota(N - 1,start,other,end);
        //把第N个最大的 从start移动到end
        System.out.println("move " + N + " from" +  start + "---->" + end);
        //再把N - 1个 全部 从other移动到end位置
        hanota(N - 1,other,end,start);
    }

}
