package com.algorithm;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = new int[]{20,10,10,30,40};
        int[] value = new int[]{100,20,50,40,70};
        System.out.println(process(weight, value, 0, 0, 60));

    }

//    private static int getMaxValue(){
//        return process();
//    }

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


}
