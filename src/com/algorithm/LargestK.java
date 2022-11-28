package com.algorithm;

/**
 * 第K大的数
 */
public class LargestK {

    public static void main(String[] args) {
        int[] arr = new int[]{34,2,4,102,67,23,1,0,33,100};
        System.out.println(quickSort(arr, 0, arr.length - 1, 1));
    }

    private static int quickSort(int[] arr,int L,int R,int K){
        int[] partition = partition(arr,L,R,arr[R]);
        if(partition[0] > arr.length - K){
            return quickSort(arr,L,partition[0] - 1,K);
        }else if(partition[0] < arr.length - K){
            return quickSort(arr,partition[0] + 1,R,K);
        }else{
            return arr[arr.length - K];
        }
    }


    private static int[] partition(int[] arr,int L,int R,int P){
        int less = L - 1;
        int more = R + 1;
        while(L < more){
            if(arr[L] > P){
                swap(arr,L,--more);
            }else if(arr[L] < P){
                swap(arr,L++,++less);
            }else{
                L++;
            }
        }
        return new int[]{less + 1,more - 1};
    }

    private static void swap(int[] arr,int L,int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }


}
