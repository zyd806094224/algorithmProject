package com.algorithm;

/**
 * 数组中的逆序对 （归并排序）
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }

    static int count = 0;

    public static int InversePairs(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private static void mergeSort(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = L + (R - L) / 2;
        mergeSort(array, L, M);
        mergeSort(array, M + 1, R);
        merge(array, L, M, R);
    }

    private static void merge(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = L;
        int j = M + 1;
        int k = 0;
        while (i <= M || j <= R) {
            if (i > M) {
                temp[k++] = array[j++];
            } else if (j > R) {
                temp[k++] = array[i++];
            } else if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count = count + (M - i + 1);
                count %= 1000000007;
            }
        }
        for (int x = 0; x < temp.length; x++) {
            array[x + L] = temp[x];
        }
    }
}
