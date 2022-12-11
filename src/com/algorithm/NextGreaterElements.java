package com.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElements {
    public static void main(String[] args) {
        /**
         * 输入: nums = [1,2,1]
         * 输出: [2,-1,2]
         * 解释: 第一个 1 的下一个更大的数是 2；
         * 数字 2 找不到下一个更大的数；
         * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/next-greater-element-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        int[] nums = new int[]{1,2,1};
        int[] ints = nextGreaterElements(nums);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < 2 * nums.length - 1;i++){
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){
                ans[stack.peek()%nums.length] = nums[i % nums.length];
                stack.pop();
            }
            stack.push(i % nums.length);
        }
        return ans;
    }
}
