package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 排序链表
 */
public class SortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midListNode = findMid(head);
        return mergeSort(sortList(head), sortList(midListNode));
    }

    private static ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = new ListNode(-1);
        dummy.next = curr;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                curr.next = new ListNode(l1.value);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.value);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = new ListNode(l1.value);
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = new ListNode(l2.value);
            l2 = l2.next;
            curr = curr.next;
        }
        return dummy.next.next;
    }

    private static ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midListNode = slow.next;
        slow.next = null;
        return midListNode;
    }
}
