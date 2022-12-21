package com.algorithm;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class StackToQueue {

    public static void main(String[] args) {

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
