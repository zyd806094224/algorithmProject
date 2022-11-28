package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 子集问题
 */
public class Subset {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<Integer> path = new ArrayList<>(); //走过的路
        List<List<Integer>> ans = new ArrayList<>();
        process(arr,0,path,ans);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    private static void process(int[] arr,int index, List<Integer> path,List<List<Integer>> ans){
        if(index == arr.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        process(arr,index + 1,path,ans);
        path.add(arr[index]);
        process(arr,index + 1,path,ans);
        path.remove(path.size() - 1);
    }
}
