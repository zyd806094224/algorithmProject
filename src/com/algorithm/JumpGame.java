package com.algorithm;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,2,3};
        System.out.println(canJump(arr));
    }

    private static boolean canJump(int[] arr){
        if(arr == null || arr.length == 1) return true;
        if(arr[0] == 0) return false;
        int range = arr[0];
        for(int i = 0;i <= range;i++){
            range = Math.max(range,i + arr[i]);
            if(range >= arr.length - 1){
                return true;
            }
        }
        return false;
    }
}
