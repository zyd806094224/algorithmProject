package com.algorithm;

import java.util.*;

/**
 * 最接近的三数之和
 */
public class TheClosestSumOfThreeNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest2(nums, 1));
    }

    /**
     * 排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }

            }
        }
        return res;
    }


    /**
     * 暴力解 超时
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest2(int[] nums, int target) {
        Set<Integer> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        process2(nums, 0, path, ans);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int x : ans) {
            if (diff > Math.abs(target - x)) {
                diff = Math.abs(target - x);
                res = x;
            }
        }
        return res;
    }

    private static void process2(int[] nums, int index, List<Integer> path, Set<Integer> ans) {
        if (path.size() == 3) {
            int res = 0;
            for (int x : path) {
                res += x;
            }
            ans.add(res);
            return;
        }
        if (index >= nums.length) {
            return;
        }
        process2(nums, index + 1, path, ans);
        path.add(nums[index]);
        process2(nums, index + 1, path, ans);
        path.remove(path.size() - 1);
    }
}
