package com.algorithm;

import com.algorithm.entity.ListNode;

/**
 * 链表最后K个节点
 */
public class FindKthToTail {

    public static void main(String[] args) {
        ListNode kthToTail = findKthToTail(ListNode.getAListNode(), 3);
        while (kthToTail != null){
            System.out.println(kthToTail.value);
            kthToTail = kthToTail.next;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public static ListNode findKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode p1 = pHead;
        int index = 0;
        boolean flag = false;
        while (p1 != null) {
            p1 = p1.next;  //p1先走k步
            index++;
            if (index == k) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        while (p1 != null) { //再一起走
            p1 = p1.next;
            pHead = pHead.next;
        }
        return pHead;
    }

}
