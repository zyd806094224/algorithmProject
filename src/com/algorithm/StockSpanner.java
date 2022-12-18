package com.algorithm;

import java.util.Stack;

/**
 * 股票的价格跨度  单调栈
 * https://leetcode.cn/problems/online-stock-span/
 * leetcode 901
 */
public class StockSpanner {
    public static void main(String[] args) {
//        [100,80,60,70,60,75,85]
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    Stack<Integer> indexStack = new Stack<>();
    Stack<Integer> valueStack = new Stack<>();
    int k = 0;

    public StockSpanner() {
        indexStack.push(-1);
        valueStack.push(Integer.MAX_VALUE);
    }

    public int next(int price) {
        while(valueStack.peek() <= price){
            valueStack.pop();
            indexStack.pop();
        }
        int res = k - indexStack.peek();
        valueStack.push(price);
        indexStack.push(k);
        k++;
        return res;
    }
}
