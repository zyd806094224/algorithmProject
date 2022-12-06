package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 删除链表中重复节点
 */
public class DeleteDuplication {

    public static void main(String[] args) {
        ListNode listNode = deleteDuplication(ListNode.getARepeatListNode());
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode curr = pHead;
        ListNode prev = dummy;
        while (curr != null) {
            int value = curr.value;
            if (curr.next != null && curr.next.value == value) {
                ListNode temp = curr.next;
                while (temp != null) {
                    if (temp.value == value) {
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
                prev.next = temp;
                curr = temp;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
