package com.algorithm;

import java.util.HashMap;

/**
 * 和为k的连续子数组个数  leetcode 560
 */
public class SubarraySumK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

    private static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //和为0 初始 最前面的位置
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
