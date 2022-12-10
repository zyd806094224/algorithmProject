package com.algorithm;

import java.util.Stack;

/**
 * 每日温度   单调栈解法
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        for (int i : dailyTemperatures(arr)) {
            System.out.print(i + ",");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); //单调栈 满足栈底到栈顶递减
        int[] ans = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
