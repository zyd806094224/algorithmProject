package com.algorithm.entity;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int value) {
        this.value = value;
    }

    /**
     * 获取一个链表
     * @return
     */
    public static ListNode getAListNode(){
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return head;
    }
}