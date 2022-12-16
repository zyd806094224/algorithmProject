package com.algorithm;

import java.util.Stack;

/**
 * 接雨水问题 双指针&单调栈解法
 */
public class RainwaterConnectionProblem {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right){
            if(leftMax < rightMax){
                if(leftMax > height[left]){
                    ans = ans + leftMax - height[left];
                    left++;
                }else{
                    leftMax = height[left];
                    left++;
                }
            }else{
                if(rightMax > height[right]){
                    ans = ans + rightMax - height[right];
                    right--;
                }else{
                    rightMax = height[right];
                    right--;
                }
            }
        }
        return ans;
    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int ans = 0;
        while(index < len){
            while(index < len && (stack.isEmpty() || height[stack.peek()] >= height[index])){
                stack.push(index++);
            }
            if(index == len){
                break;
            }
            while(!stack.isEmpty() && height[stack.peek()] < height[index]){
                int currIndex = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int w = index - stack.peek() - 1;
                int h = Math.min(height[index],height[stack.peek()]) - height[currIndex];
                ans = ans + w * h;
            }
        }
        return ans;

    }
}
