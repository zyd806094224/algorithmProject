package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 约瑟夫环问题
 * 0 - n编号小朋友成环，0 -> m-1 之间报号
 */
public class JosephRingProblem {
    public static void main(String[] args) {
        System.out.println(lastRemaining_Solution(5, 3));
    }

    public static int lastRemaining_Solution(int n, int m) {
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr.next = dummy.next;
        ListNode prev = curr;
        ListNode move = head;
        while (move.next.value != move.value) {
            for (int i = 0; i < m; i++) {
                if (i == m - 1) {
                    prev.next = prev.next.next;
                    move = prev.next;
                } else {
                    move = move.next;
                    prev = prev.next;
                }
            }
        }
        return move.value;
    }
}
