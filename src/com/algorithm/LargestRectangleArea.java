package com.algorithm;

import java.util.Stack;

/**
 * 柱状图中最大矩形  单调栈
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //添加一个最左侧的边界   最右侧的边界为len
        int index = 0;
        int max = 0;
        while(index < len){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[index]){ //不满足严格单调递增了，计算之前的max
                max = Math.max(max,heights[stack.pop()] * (index - stack.peek() - 1));
            }
            stack.push(index++);
        }
        while(stack.peek() != -1){ //最后如果还存在一个严格单调递增的栈
            max = Math.max(max,heights[stack.pop()] * (len - stack.peek() - 1));  //len为最右侧的边界
        }
        return max;

    }
}
