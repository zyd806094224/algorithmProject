package com.algorithm;

import java.util.Arrays;

/**
 * 滑动窗口中位数  leetcode 480
 */
public class MedianSlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        for (double v : medianSlidingWindow(arr, 3)) {
            System.out.println(v);
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        int[] window = new int[k];
        for(int i = 0;i < k;i++){
            window[i] = nums[i];
        }
        Arrays.sort(window); //排好序的窗口
        ans[0] = getWindowMid(window);
        for(int i = 0;i < nums.length - k;i++){
            int index = find(window,nums[i]);//窗口需要移除的数
            window[index] = nums[i + k];  //窗口要新加入的数
            //向后冒泡
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //向前冒泡
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            ans[i + 1] = getWindowMid(window);
        }
        return ans;
    }

    private static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static double getWindowMid(int[] window){
        if(window.length % 2 == 0){
            return window[window.length/2 - 1] /2.0 + window[window.length/2]/2.0;
        }else{
            return window[window.length/2];
        }
    }

    private static int find(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
