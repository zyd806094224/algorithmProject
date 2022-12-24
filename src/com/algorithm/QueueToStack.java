package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列转换成栈
 */
public class QueueToStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        while(!myStack.empty()){
            System.out.println(myStack.pop());
        }
    }

    static class MyStack {

        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
                queue1.offer(x);
            } else {
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
                queue2.offer(x);
            }
        }

        public int pop() {
            while (!queue1.isEmpty()) {
                if (queue1.size() == 1) {
                    return queue1.poll();
                } else {
                    queue2.offer(queue1.poll());
                }
            }
            while (!queue2.isEmpty()) {
                if (queue2.size() == 1) {
                    return queue2.poll();
                } else {
                    queue1.offer(queue2.poll());
                }
            }
            return -1;
        }

        public int top() {
            while (!queue1.isEmpty()) {
                if (queue1.size() == 1) {
                    int value = queue1.peek();
                    queue2.offer(queue1.poll());
                    return value;
                } else {
                    queue2.offer(queue1.poll());
                }
            }
            while (!queue2.isEmpty()) {
                if (queue2.size() == 1) {
                    int value = queue2.peek();
                    queue1.offer(queue2.poll());
                    return value;
                } else {
                    queue1.offer(queue2.poll());
                }
            }
            return -1;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
