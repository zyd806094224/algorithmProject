package com.algorithm;

import com.algorithm.entity.ListNode;

public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode3.next = listNode6;

        //1->2->3->6->7
        //4->5->6->7    common: 6->7

        ListNode resNode = findFirstCommonNode(listNode1, listNode4);
        while (resNode != null) {
            System.out.println(resNode.value);
            resNode = resNode.next;
        }
    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            if (p1 == null) {
                p1 = pHead2;
                pHead2 = null;
            }
            p2 = p2.next;
            if (p2 == null) {
                p2 = pHead1;
                pHead1 = null;
            }
        }
        return null;
    }
}
