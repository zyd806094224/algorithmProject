package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 移掉K位数字 返回最小的数字  单调栈应用  leetcode 402
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String str = "12022231";
        System.out.println(removeKDigits(str, 4));
    }

    public static String removeKDigits(String num, int k) {
        int len = num.length();
        int count = len - k;
        if(count == 0){
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while(index < len){
            while(index < len && (stack.isEmpty() || stack.peekLast() <= num.charAt(index))){
                stack.addLast(num.charAt(index++));
            }
            if(index == len){
                break;
            }
            while(!stack.isEmpty() && stack.peekLast() > num.charAt(index) && stack.size() + len - index - 1 >= count){
                stack.removeLast();
            }
            stack.addLast(num.charAt(index++));
        }
        index = 0;
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && index < count){
            if(sb.length() == 0 && stack.peekFirst() == '0'){
                stack.removeFirst();
            }else{
                sb.append(stack.removeFirst());
            }
            index++;
        }
        if(sb.toString().equals("")){
            return "0";
        }
        return sb.toString();
    }
}
