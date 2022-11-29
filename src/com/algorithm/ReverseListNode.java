package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 反转单链表
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode aListNode = ListNode.getAListNode();
        ListNode res = reverse(aListNode);
        while (res != null){
            System.out.print(res.value + ",");
            res = res.next;
        }
    }

    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next,prev = null,curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
