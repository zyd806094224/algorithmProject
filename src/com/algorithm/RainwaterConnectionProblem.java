package com.algorithm;

/**
 * 接雨水问题 双指针解法
 */
public class RainwaterConnectionProblem {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

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
}
