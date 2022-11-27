package com.algorithm;

public class QuickSort3 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,5,1,-30,3,6,7,32,11,6};
        quickSort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int find(int[] arr, int x) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void quickSort(int[] arr,int L,int R){
        if(arr == null || arr.length < 2){
            return;
        }
        if(L < R){
            swap(arr, (int) (L + Math.random()*(R - L + 1)),R);
            int[] partition = partition(arr, L, R,arr[R]);
            quickSort(arr,L,partition[0] - 1);
            quickSort(arr,partition[1] + 1,R);
        }
    }

    /**
     * @param arr
     * @param L
     * @param R
     * @return  等于区域左右边界
     */
    public static int[] partition(int arr[],int L,int R,int P){
        int less = L - 1; //小于区域右边界
        int more = R + 1; //大于区域左边界
        while (L < more){
            if(arr[L] < P){ //当前数小于划分值   以数组的最右一个值做partition
                swap(arr,L++,++less);
            }else if(arr[L] > P){//当前数大于划分值
                swap(arr,L,--more);
            }else{
                L++;
            }
        }
        return new int[]{less + 1,more - 1};
    }

    public static void swap(int[] arr,int L,int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
