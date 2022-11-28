package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class FullArrangement {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        List<List<Integer>> ans = new ArrayList<>();
        process(arr,0,ans);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    private static void process(int[] arr, int index, List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        for(int i = index;i < arr.length;i++){
            swap(arr,index,i);
            process(arr,index + 1,ans);
            swap(arr,index,i);
        }
    }

    private static void swap(int[] arr,int L,int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
