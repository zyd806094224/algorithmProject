package com.algorithm;

import java.util.*;

/**
 * 数组求交集
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5}, nums2 = new int[]{9, 4, 9, 8, 4};
        for (int i : intersect(nums1, nums2)) {
            System.out.println(i);
        }
    }

    /**
     * 两个数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    /**
     * 多个数组
     * @param nums
     * @return
     */
    public List<Integer> intersection(int[][] nums) {
        int m = nums.length;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int i : arr) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
                if (map.get(i) == m) {
                    ans.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
