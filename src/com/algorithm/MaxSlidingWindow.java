package com.algorithm;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 双端队列
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = maxSlidingWindow(nums, 3);
        for (int an : ans) {
            System.out.print(an + ",");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int L = 0;
        int R = k - 1;
        int[] ans = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                queue.addLast(i);
            } else {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
            }
        }
        ans[0] = nums[queue.peekFirst()];
        while (R < len - 1) {
            L++;
            R++;
            if (L - 1 == queue.peekFirst()) { //上一个窗口的最前的位置
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[R]) {
                queue.pollLast();
            }
            queue.addLast(R);
            ans[L] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
