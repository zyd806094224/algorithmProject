package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 反转单链表
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode res = reverse(listNode1);
        while (res != null){
            System.out.print(res.value + ",");
            res = res.next;
        }
    }

    private static ListNode reverse(ListNode listNode){
        if(listNode == null || listNode.next == null) return listNode;
        ListNode next,prev = null,curr = listNode;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
