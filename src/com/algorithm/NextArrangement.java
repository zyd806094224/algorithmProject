package com.algorithm;

/**
 * 下一个排列
 */
public class NextArrangement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        nextNum(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static int[] nextNum(int[] arr){
        if(arr == null) return null;
        if(arr.length < 2) return arr;
        int N = arr.length;
        int firstLessIndex = -1; //从右往左第一个变小的数所在位置  记录
        for(int i = N - 2;i >= 0;i--){
            if(arr[i] < arr[i + 1]){
                firstLessIndex = i;
                break;
            }
        }
        if(firstLessIndex == -1){
            reverse(arr,0,N - 1);
        }else{
            for (int i = N - 1; i >= 0 ; i--) {
                if(arr[i] > arr[firstLessIndex]){
                    swap(arr,i,firstLessIndex);
                    reverse(arr,firstLessIndex + 1,N - 1);
                    break;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void reverse(int[] arr,int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


}
