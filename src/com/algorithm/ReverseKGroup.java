package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * K个一组翻转链表
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode listNode = reverseKGroup(ListNode.getAListNode(), 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        a:
        while (curr != null) {
            ListNode start = curr;
            ListNode end = curr;
            for (int i = 0; i < k - 1 && end != null; i++) {
                if (end != null) {
                    end = end.next;
                } else {
                    break a;
                }
            }
            if (end == null) {
                break a;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode res = reverse(start);
            start.next = next;
            prev.next = res;
            prev = start;
            curr = prev.next;
        }
        return dummy.next;

    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next, curr = head, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
