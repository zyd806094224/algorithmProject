package com.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子集问题2 去重
 */
public class Subset2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        List<Integer> path = new ArrayList<>(); //走过的路
        Set<List<Integer>> ans = new HashSet<>();
        process(arr,0,path,ans);
        for (List<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    private static void process(int[] arr, int index, List<Integer> path, Set<List<Integer>> ans){
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
