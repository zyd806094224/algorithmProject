package com.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElement {
    public static void main(String[] args) {

        /**
         * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
         * 输出：[-1,3,-1]
         * 解释：nums1 中每个值的下一个更大元素如下所述：
         * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
         * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
         * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/next-greater-element-i
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < nums2.length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                for(int j = 0;j < nums1.length;j++){
                    if(nums1[j] == nums2[stack.peek()]){
                        ans[j] = nums2[i];
                        break;
                    }
                }
                stack.pop();
            }
            stack.push(i);
        }
        return ans;

    }
}
