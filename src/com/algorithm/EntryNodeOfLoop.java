package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 链表中环的入口
 */
public class EntryNodeOfLoop {

    public static void main(String[] args) {
        ListNode resNode = entryNodeOfLoop(ListNode.getAAnnularListNode());
    }

    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag) {
            while (pHead != null) {
                if (pHead == slow) {
                    return slow;
                }
                pHead = pHead.next;
                slow = slow.next;
            }
        }
        return null;
    }
}
