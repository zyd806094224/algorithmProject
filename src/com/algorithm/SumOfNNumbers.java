package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N数之和
 */
public class SumOfNNumbers {
    public static void main(String[] args) {
        //-1 ,0,1,-2,3
        int[] arr = new int[]{-1,0,1,-2,3,4,-3,9,-9};
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTracking(0,3,0,arr,list,res);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list1 = res.get(i);
        }
    }

    private static void backTracking(int start,int sum,int target,int[] arr,List<Integer> list,List<List<Integer>> res){
        if(sum > 2){
            for(int i = start;i < arr.length;i++){
                list.add(arr[i]);
                backTracking(i + 1,sum - 1,target - arr[i],arr,list,res);
                list.remove(list.size() - 1);
            }
        }else{
            int left = start;
            int right = arr.length - 1;

            while(left < right){
                int total = arr[left] + arr[right];
                if(total > target){
//                    do{
//                        right--;
//                    }while (left < right);
                    right--;
                }else if(total < target){
                    left++;
                }else{
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    left++;
                    right--;
                }
            }
        }

    }
}
